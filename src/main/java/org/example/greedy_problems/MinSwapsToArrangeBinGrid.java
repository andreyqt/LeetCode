package org.example.greedy_problems;

/**
 * task: <a href="https://leetcode.com/problems/minimum-swaps-to-arrange-a-binary-grid/">Minimum Swaps to Arrange a Binary Grid</a><br>
 * time complexity: {@code O(N^2)}<br>
 * space complexity: {@code O(N)}<br>
 * difficulty: {@code medium}
 */
public class MinSwapsToArrangeBinGrid {

    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] zeroes = new int[n];

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) {
                    count++;
                } else {
                    break;
                }
            }
            zeroes[i] = count;
        }

        int swaps = 0;
        for (int i = 0; i < n; i++) {
            int needed = n - 1 - i;
            int found = -1;

            for (int j = i; j < n; j++) {
                if (zeroes[j] >= needed) {
                    found = j;
                    break;
                }
            }

            if (found == -1) {
                return -1;
            }

            for (int j = found; j > i; j--) {
                int temp = zeroes[j];
                zeroes[j] = zeroes[j - 1];
                zeroes[j - 1] = temp;
                swaps++;
            }
        }

        return swaps;
    }

}
