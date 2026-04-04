package org.example.matrix;

/**
 * task: <a href="https://leetcode.com/problems/rotate-image/description/">Rotate Image</a><br>
 * time complexity: {@code O(n^2)}<br>
 * space complexity: {@code O(1)}<br>
 * difficulty: {@code medium}
 */
public class RotateImage {

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j ++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

}
