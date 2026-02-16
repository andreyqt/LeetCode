package org.example.contest_6_2_26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TaskOne {

    static int n;
    static int m;
    static int maxSum = 0;
    static int[] values;
    static boolean[] visited;
    static List<Integer>[] graph;

    static void findMax(int island, int currentSum) {
        visited[island] = true;
        currentSum = currentSum + values[island];
        if (currentSum > maxSum) {
            maxSum = currentSum;
        }
        for (int neighbor: graph[island]) {
            if (!visited[neighbor]) {
                findMax(neighbor, currentSum);
            }
        }
        visited[island] = false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(st.nextToken());
        }
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            graph[a].add(b);
            graph[b].add(a);
        }
        visited = new boolean[n];
        maxSum = 0;
        findMax(0, 0);
        System.out.println(maxSum);
    }

}
