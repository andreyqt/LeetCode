package org.example.atoi;

/**
 * task: <a href="https://leetcode.com/problems/string-to-integer-atoi/description/">atoi</a><br>
 * time complexity: {@code O(N)}<br>
 * space complexity: {@code O(1)}<br>
 * difficulty: {@code medium}
 */
public class Atoi {

    public int myAtoi(String s) {
        String str = s.trim();

        if (str.isEmpty()) {
            return 0;
        }

        int sign = 1;
        int result = 0;
        int i = 0;

        if (str.charAt(0) == '-' || str.charAt(0) == '+') {
            if (str.charAt(0) == '-') {
                sign = -1;
            }
            i++;
        }

        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            int digit = str.charAt(i) - '0';
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + digit;
            i++;
        }

        return result * sign;
    }

}
