package org.example.greedy_problems;

import java.util.Arrays;

/**
 * task: <a href="https://leetcode.com/problems/largest-submatrix-with-rearrangements/">Largest Submatrix With Rearrangements</a><br>
 * time complexity: {@code O(rows * cols * Log(cols))}
 * space complexity: {@code O(cols)}
 * difficulty: {@code medium}
 */
public class LargestSubmatrix {

    public int largestSubmatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int maxArea = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (matrix[i][j] == 1) {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            int[] sortedHeights = heights.clone();
            Arrays.sort(sortedHeights);

            for (int j = 0; j < cols; j++) {
                if (sortedHeights[j] > 0) {
                    maxArea = Math.max(maxArea, (cols - j) * sortedHeights[j]);
                }
            }
        }
        return maxArea;
    }

}
