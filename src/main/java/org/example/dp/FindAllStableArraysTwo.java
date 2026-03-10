package org.example.dp;

/**
 * task: <a href="https://leetcode.com/problems/find-all-possible-stable-binary-arrays-ii/">Find All Possible Stable Binary Arrays II</a><br>
 * time complexity: {@code O(Z * O)}<br>
 * space complexity: {@code O(Z * O)}<br>
 * difficulty: {@code hard}
 */
public class FindAllStableArraysTwo {

    public int numberOfStableArrays(int zero, int one, int limit) {
        int mod = 1_000_000_007;
        long[][][] dp = new long[zero + 1][one + 1][2];

        for (int i = 1; i <= Math.min(zero, limit); i++) {
            dp[i][0][0] = 1;
        }

        for (int j = 1; j <= Math.min(one, limit); j++) {
            dp[0][j][1] = 1;
        }

        for (int i = 1; i <= zero; i++) {
            for (int j = 1; j <= one; j++) {

                long last0 = (i - limit - 1 >= 0) ? dp[i - limit - 1][j][1] : 0;
                long last1 = (j - limit - 1 >= 0) ? dp[i][j - limit - 1][0] : 0;

                dp[i][j][0] = (dp[i - 1][j][0] + dp[i - 1][j][1] - last0 + mod) % mod;
                dp[i][j][1] = (dp[i][j - 1][0] + dp[i][j - 1][1] - last1 + mod) % mod;
            }
        }

        return (int) ((dp[zero][one][0] + dp[zero][one][1]) % mod);
    }

}
