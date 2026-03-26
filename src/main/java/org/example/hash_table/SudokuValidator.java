package org.example.hash_table;

import java.util.HashSet;

/**
 * task: <a href="https://leetcode.com/problems/valid-sudoku/description/">Valid Sudoku</a><br>
 * time complexity: {@code O(1)}<br>
 * space complexity: {@code O(1)}<br>
 * difficulty: {@code medium}
 */
public class SudokuValidator {

    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];

                if (num != '.') {
                    String rowKey = num + " in row " + i;
                    String colKey = num + " in col " + j;
                    String boxKey = num + " in box " + (i/3) + "-" + (j/3);

                    if (!seen.add(rowKey) ||
                        !seen.add(colKey) ||
                        !seen.add(boxKey)) {
                        return false;
                    }
                }

            }
        }
        return true;
    }

}
