package org.example.zigzag_conversion;

/**
 * task: <a href="https://leetcode.com/problems/zigzag-conversion/description/">Zigzag conversion</a><br>
 * time complexity: {@code O(N)}<br>
 * space complexity: {@code O(N)}<br>
 * difficulty: {@code medium}
 */
public class ZigzagConversion {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            if (i == 0 || i == numRows - 1) {
                for (int j = i; j < s.length(); j = j + (numRows - 1) * 2) {
                    builder.append(s.charAt(j));
                }
            } else {
                int j = i;
                int step = 1;
                while (j < s.length()) {
                    builder.append(s.charAt(j));
                    if (step % 2 == 1) {
                        j = j + (numRows - 1) * 2 - 2 * i;
                    } else {
                        j = j + 2 * i;
                    }
                    step++;
                }
            }
        }
        return builder.toString();
    }

}
