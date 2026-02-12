package org.example.partition_labels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * task: <a href="https://leetcode.com/problems/partition-labels/description/">Partition labels</a><br>
 * difficulty: {@code medium}
 */
public class PartitionLabels {

    /**
     * time complexity: {@code O(N)}<br>
     * space complexity: {@code O(K)}<br>
     */
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> lastIndexes = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            lastIndexes.put(s.charAt(i), i);
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            end = Math.max(end, lastIndexes.get(c));

            if (end == i) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }
        return result;
    }

    /**
     * time complexity: {@code O(N)}<br>
     * space complexity: {@code O(1)}<br>
     */
    public List<Integer> partitionLabels2(String s) {
        List<Integer> result = new ArrayList<>();
        int[] idx = new int[26];

        for (int i = 0; i < s. length(); i++) {
            idx[s.charAt(i) - 'a'] = i;
        }

        int start = 0;
        int end = 0;

        for (int j = 0; j < s.length(); j ++) {
            char c = s.charAt(j);
            end = Math.max(end, idx[c-'a']);

            if (end == j) {
                result.add(end - start + 1);
                start = j + 1;
            }
        }

        return result;
    }

}
