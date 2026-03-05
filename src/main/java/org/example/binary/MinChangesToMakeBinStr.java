package org.example.binary;

/**
 * task: <a href="https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/">Minimum Changes To Make Alternating Binary String</a><br>
 * time complexity: {@code O(N)}<br>
 * space complexity: {@code O(1)}<br>
 * difficulty: {@code medium}
 */
public class MinChangesToMakeBinStr {

    public int minOperations(String s) {
        if (s.isEmpty() || s.length() == 1) return 0;

        int count1 = 0;
        for (int i = 0; i < s.length(); i++) {
            char expected = (i % 2 == 0) ? '0' : '1';
            if (s.charAt(i) != expected) {
                count1++;
            }
        }

        int count2 = 0;
        for (int i = 0; i < s.length(); i++) {
            char expected = (i % 2 == 0) ? '1' : '0';
            if (s.charAt(i) != expected) {
                count2++;
            }
        }

        return Math.min(count1, count2);
    }

}
