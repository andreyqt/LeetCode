package org.example.binary;

/**
 * task: <a href="https://leetcode.com/problems/special-positions-in-a-binary-matrix/">Special Positions in a Binary Matrix</a><br>
 * time complexity: {@code O(N * M)}<br>
 * space complexity: {@code O(N + M)}<br>
 * difficulty: {@code easy}
 */
public class SpecialPositionsInMatrix {

    public int numSpecial(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[] OnesInRows = new int[n];
        int[] OnesInColumns = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    OnesInRows[i]++;
                    OnesInColumns[j]++;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1 && OnesInRows[i] == 1 && OnesInColumns[j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }

}
