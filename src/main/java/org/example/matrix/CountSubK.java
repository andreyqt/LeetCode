package org.example.matrix;

/**
 * task: <a href="https://leetcode.com/problems/count-submatrices-with-top-left-element-and-sum-less-than-k/">Count Submatrices with Top-Left Element and Sum Less Than k</a><br>
 * difficulty: {@code medium}
 */
public class CountSubK {

    /**
     * time complexity: {@code O(n * m)}<br>
     * space complexity: {@code O(m * n)}<br>
     */
    public int countSubmatrices(int[][] grid, int k) {
        int count = 0;
        int n = grid.length, m = grid[0].length;

        int[][] prefix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                prefix[i][j] = grid[i][j];
                if (i > 0) prefix[i][j] += prefix[i-1][j];
                if (j > 0) prefix[i][j] += prefix[i][j-1];
                if (i > 0 && j > 0) prefix[i][j] -= prefix[i-1][j-1];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (prefix[i][j] <= k) {
                    count++;
                }
            }
        }

        return count;
    }

    /**
     * time complexity: {@code O(n * m)}<br>
     * space complexity: {@code O(m)}<br>
     */
    public int countSubmatrices2(int[][] grid, int k) {
        int count = 0;
        int n = grid.length, m = grid[0].length;
        int[] rowSum = new int[m];

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                rowSum[j] += grid[i][j];
                sum += rowSum[j];
                if (sum <= k) count++;
                else break;
            }
        }
        return count;
    }

}