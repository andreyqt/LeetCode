package org.example.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * task: <a href="https://leetcode.com/problems/top-k-frequent-elements/">Top K Frequent Elements</a><br>
 * time complexity: {@code O(N*log(K))}<br>
 * space complexity: {@code O(N+K)}<br>
 * difficulty: {@code medium}
 */
public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for (int num : map.keySet()) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = heap.poll();
        }
        return res;
    }

    /**
     * time complexity: O(N)<br>
     * space complexity: O(N)<br>
     */
    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int maxFrequency = Collections.max(map.values());
        List<Integer>[] buckets = new List[maxFrequency + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            buckets[entry.getKey()].add(entry.getValue());
        }

        int[] res = new int[k];
        int idx = 0;
        for (int i = maxFrequency; i >= 0 && idx < k; i++) {
            for (Integer num : buckets[i]) {
                res[idx++] = num;
                if (idx == k) {
                    break;
                }
            }
        }
        return res;
    }

}
