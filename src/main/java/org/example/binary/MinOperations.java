package org.example.binary;

/**
 * task: <a href="https://leetcode.com/problems/minimum-operations-to-equalize-binary-string/">Minimum Operations to Equalize Binary String</a><br>
 * time complexity: {@code O(N)}<br>
 * space complexity: {@code O(1)}<br>
 * difficulty: {@code hard}
 */
public class MinOperations {

    public int minOperations(String s, int k) {
        int n = s.length();
        int count0 = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') count0++;
        }
        if (count0 == 0) return 0;

        for (int m = 1; m <= n; m++) {
            if (m * k < count0) continue;
            if ((m * k - count0) % 2 != 0) continue;

            int R = m * k - count0;
            int maxPairs = count0 * ((m - 1) / 2) + (n - count0) * (m / 2);
            if (R / 2 <= maxPairs) {
                return m;
            }
        }
        return -1;
    }

}
