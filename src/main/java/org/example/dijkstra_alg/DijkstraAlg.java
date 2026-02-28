package org.example.dijkstra_alg;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * link: <a href="https://www.geeksforgeeks.org/java/dijkstras-shortest-path-algorithm-in-java-using-priorityqueue/">GFG</a><br>
 * time complexity: {@code O(V + E*Log(V))}<br>
 * space complexity: {@code O(V + E)}<br>
 */
public class DijkstraAlg {

    private int[] dist;
    private Set<Integer> settled;
    private PriorityQueue<Node> pq;
    private int V;
    List<List<Node>> adj;

    public DijkstraAlg(int V) {
        this.V = V;
        dist = new int[V];
        settled = new HashSet<Integer>();
        pq = new PriorityQueue<Node>(V, new Node());
    }

    public void dijkstra(List<List<Node>> adj, int source) {
        this.adj = adj;

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        pq.add(new Node(source, 0));
        dist[source] = 0;

        while (settled.size() != V) {
            if (pq.isEmpty()) {
                return;
            }

            int u = pq.remove().node;
            if (settled.contains(u)) continue;
            settled.add(u);
            processNeighbours(u);
        }
    }

    private void processNeighbours(int u) {
        int edgeDistance = -1;
        int newDistance = -1;

        for (int i = 0; i < adj.get(u).size(); i++) {
            Node v = adj.get(u).get(i);

            if (!settled.contains(v.node)) {
                edgeDistance = v.cost;
                newDistance = dist[u] + edgeDistance;

                if (newDistance < dist[v.node]) {
                    dist[v.node] = newDistance;
                }

                pq.add(new Node(v.node, newDistance));
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        int source = 0;
        List<List<Node>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            List<Node> items = new ArrayList<>();
            adj.add(items);
        }

        adj.get(0).add(new Node(1, 9));
        adj.get(0).add(new Node(2, 6));
        adj.get(0).add(new Node(3, 5));
        adj.get(0).add(new Node(4, 3));
        adj.get(2).add(new Node(1, 2));
        adj.get(2).add(new Node(3, 4));

        DijkstraAlg dijkstra = new DijkstraAlg(V);
        dijkstra.dijkstra(adj, source);

        System.out.println("The shortest path from node: ");
        for (int i = 0; i < dijkstra.dist.length; i++) {
            System.out.println(source + " to " + i + " is " + dijkstra.dist[i]);
        }
    }

}
