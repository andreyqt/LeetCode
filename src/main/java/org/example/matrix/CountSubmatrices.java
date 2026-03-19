package org.example.matrix;

/**
 * task: <a href="https://leetcode.com/problems/count-submatrices-with-equal-frequency-of-x-and-y">Count Submatrices With Equal Frequency of X and Y</a><br>
 * time complexity: {@code O(n * m)} for all operations<br>
 * space complexity: {@code O(n * m)}<br>
 * difficulty: {@code medium}
 */
public class CountSubmatrices {

    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        int[][] countX = new int[n][m];
        int[][] countY = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (i > 0) {
                    countX[i][j] = countX[i - 1][j];
                    countY[i][j] = countY[i - 1][j];
                }

                if (j > 0) {
                    countX[i][j] += countX[i][j - 1] - (i > 0 ? countX[i - 1][j - 1] : 0);
                    countY[i][j] += countY[i][j - 1] - (i > 0 ? countY[i - 1][j - 1] : 0);
                }

                if (grid[i][j] == 'X') {
                    countX[i][j]++;
                } else if (grid[i][j] == 'Y') {
                    countY[i][j]++;
                }

                if (countX[i][j] == countY[i][j] && countX[i][j] > 0) {
                    count++;
                }

            }
        }
        return count;
    }

}
