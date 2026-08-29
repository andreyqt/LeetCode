package org.example.dfs_bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * task: <a href="https://coderun.yandex.ru/selections/yandex-interview/problems/interesting-journey">Interesting Journey</a><br>
 * time complexity: {@code O()}
 * space complexity: {@code O()}
 * difficulty: {@code easy}
 */
public class JourneyYdx {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(reader.readLine());

        int[][] cities = new int[cnt][2];
        for (int i = 0; i < cnt; i++) {
            String[] parts = reader.readLine().split(" ");
            cities[i][0] = Integer.parseInt(parts[0]);
            cities[i][1] = Integer.parseInt(parts[1]);
        }

        int k = Integer.parseInt(reader.readLine());

        String[] parts = reader.readLine().split(" ");
        int start = Integer.parseInt(parts[0]) - 1;
        int end = Integer.parseInt(parts[1]) - 1;
        reader.close();

        int[] dist = new int[cnt];
        Arrays.fill(dist, -1);
        dist[start] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next = 0; next < cnt; next++) {
                if (dist[next] != -1) {
                    continue;
                }

                long distance = Math.abs((long)cities[next][0] - (long)cities[cur][0])
                        + Math.abs((long)cities[next][1] - (long)cities[cur][1]);

                if (distance <= k) {
                    dist[next] = dist[cur] + 1;
                    queue.offer(next);
                }
            }

        }

        writer.write(String.valueOf(dist[end]));
        writer.close();
    }

}
