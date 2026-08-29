package org.example.contest_06_06_26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class TaskOne {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] values = new int[size];
        for (int i = 0; i < size; i++) {
            values[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> firstIdx = new HashMap<>();
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < size; i++) {
            firstIdx.putIfAbsent(values[i], i);
            freq.put(values[i], freq.getOrDefault(values[i], 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {
            int freqDiff = freq.get(b) - freq.get(a);
            if (freqDiff != 0) {
                return freqDiff;
            } else {
                return firstIdx.get(a) - firstIdx.get(b);
            }
        });
        pq.addAll(freq.keySet());

        StringBuilder result = new StringBuilder();
        while (!pq.isEmpty()) {
            int num = pq.poll();
            for (int i = 0; i < freq.get(num); i++) {
                result.append(num).append(" ");
            }
        }
        System.out.println(result);

    }

}
