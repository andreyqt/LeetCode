package org.example.string_tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * task: <a href="https://leetcode.com/problems/find-all-anagrams-in-a-string/">Find All Anagrams in a String</a><br>
 * time complexity: {@code O(N)}
 * space complexity: {@code O(1)}
 * difficulty: {@code medium}
 */
public class FindAllAnagrams {

    public List<Integer> findAllAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] counts = new int[26];
        int[] windowCount = new int[26];

        for (char c : p.toCharArray()) {
            counts[c - 'a']++;
        }

        int windowSize = p.length();
        for (int i = 0; i < s.length(); i++) {
            windowCount[s.charAt(i) - 'a']++;

            if (i >= windowSize) {
                windowCount[s.charAt(i - windowSize) - 'a']--;
            }

            if (Arrays.equals(counts, windowCount)) {
                result.add(i - windowSize + 1);
            }

        }

        return result;
    }

}
