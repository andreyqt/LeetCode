package org.example.string_tasks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * task: <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters"/>Longest Substring Without Repeating Characters</a><br>
 * difficulty: {@code medium}
 */
public class LSWRC {

    /**
     * time complexity: {@code O(N)}<br>
     * space complexity: {@code O(K)}<br>
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (map.containsKey(ch)) {
                left = Math.max(left, map.get(ch) + 1);
            }
            map.put(ch, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    /**
     * time complexity: {@code O(N)}<br>
     * space complexity: {@code O(1)}<br>
     */
    public int lengthOfLongestSubstring2(String s) {
        int[] lastIndex = new int[128];
        Arrays.fill(lastIndex, -1);

        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (lastIndex[ch] >= left) {
                left = lastIndex[ch] + 1;
            }
            lastIndex[ch] = right;
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

}
