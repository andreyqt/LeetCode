package org.example.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * task: <a href="https://leetcode.com/problems/top-k-frequent-words/">Top K Frequent Words</a><br>
 * time complexity: {@code O(N*log(K))}<br>
 * space complexity: {@code O(N)}<br>
 * difficulty: {@code medium}
 */
public class TopKFrequentWords {

    public List<String> topKFrequentWords(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> heap = new PriorityQueue<>(
                (a, b) -> {
                    int frequency = freq.get(a).compareTo(freq.get(b));
                    if (frequency == 0) {
                        return b.compareTo(a);
                    }
                    return frequency;
                }
        );

        for (String word : freq.keySet()) {
            heap.offer(word);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        List<String> res = new ArrayList<>();
        while (!heap.isEmpty()) {
            res.add(heap.poll());
        }
        Collections.reverse(res);
        return res;
    }

}
