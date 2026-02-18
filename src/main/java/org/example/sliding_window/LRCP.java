package org.example.sliding_window;

/**
 * task: <a href="https://leetcode.com/problems/longest-repeating-character-replacement/">LRCP</a><br>
 * time complexity: {@code O(N)}
 * space complexity: {@code O(1)}
 * difficulty: {@code medium}
 */
public class LRCP {

    public int characterReplacement(String s, int k) {
        if (s.isEmpty()) {
            return 0;
        }

        int[] count = new int[26];
        int left = 0, maxCount = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            count[currentChar - 'A']++;
            maxCount = Math.max(maxCount, count[currentChar - 'A']);

            while((right - left  + 1) - maxCount > k) {
                char leftChar = s.charAt(left);
                count[leftChar - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

}
