package org.example.prefix;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * task: <a href="https://leetcode.com/problems/get-biggest-three-rhombus-sums-in-a-grid/">Get Biggest Three Rhombus Sums in a Grid</a><br>
 * time complexity: {@code O(N*M*min(M,N)^2)}<br>
 * space complexity: {@code O(1)}<br>
 * difficulty: {@code medium}
 */
public class BiggestThree {

    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        TreeSet<Integer> sums = new TreeSet<>(Collections.reverseOrder());

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sums.add(grid[i][j]);

                int maxK = Math.min(
                        Math.min(i, m - 1 - i),
                        Math.min(j, n - 1 - j)
                );

                for (int k = 1; k <= maxK; k++) {
                    int sum = 0;

                    for (int dx = -k; dx <= k; dx++) {
                        int x = i + dx;
                        int y1 = j - (k - Math.abs(dx));
                        int y2 = j + (k - Math.abs(dx));

                        if (dx == -k || dx == k) {
                            sum += grid[x][y1];
                        } else {
                            sum += grid[x][y1] + grid[x][y2];
                        }
                    }

                    sums.add(sum);
                }
            }
        }

        int[] result = new int[Math.min(3, sums.size())];
        Iterator<Integer> it = sums.iterator();
        for (int i = 0; i < result.length; i++) {
            result[i] = it.next();
        }
        return result;
    }

}
