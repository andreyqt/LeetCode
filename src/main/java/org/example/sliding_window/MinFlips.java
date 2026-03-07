package org.example.sliding_window;

/**
 * task: <a href="https://leetcode.com/problems/minimum-number-of-flips-to-make-the-binary-string-alternating/">Minimum Number of Flips to Make the Binary String Alternating</a><br>
 * time complexity: {@code O(N)}<br>
 * space complexity: {@code O(N)}<br>
 * difficulty: {@code medium}
 */
public class MinFlips {

    public int minFlips(String s) {
        int n = s.length();
        s = s + s;

        char[] pattern1 = new char[2 * n];
        char[] pattern2 = new char[2 * n];

        for (int i = 0; i < 2 * n; i++) {
            pattern1[i] = (i % 2 == 0) ? '0' : '1';
            pattern2[i] = (i % 2 == 0) ? '1' : '0';
        }

        int diff1 = 0, diff2 = 0;
        int minFlips = Integer.MAX_VALUE;

        for (int i = 0; i < 2 * n; i++) {
            if (s.charAt(i) != pattern1[i]) diff1++;
            if (s.charAt(i) != pattern2[i]) diff2++;

            if (i >= n) {
                if (s.charAt(i - n) != pattern1[i - n]) diff1--;
                if (s.charAt(i - n) != pattern2[i - n]) diff2--;
            }

            if (i >= n - 1) {
                minFlips = Math.min(minFlips, Math.min(diff1, diff2));
            }
        }

        return minFlips;
    }

}
