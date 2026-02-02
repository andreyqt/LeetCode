package org.example.reverse_integer;

/**
 * task: <a href="https://leetcode.com/problems/reverse-integer/description/"/>Reverse Integer</a><br>
 * difficulty: {@code medium}
 */
public class ReverseInteger {

    /**
     * time complexity: {@code O(N)}<br>
     * space complexity: {@code O(N)}<br>
     */
    public int reverse(int x) {
        String s = String.valueOf(x);
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '-') {
                sb.insert(0, s.charAt(i));
                continue;
            }
            sb.append(s.charAt(i));
        }
        try {
            return Integer.parseInt(sb.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    /**
     * time complexity: {@code O(log_10(N))}<br>
     * space complexity: {@code O(1)}<br>
     */
    public int reverse2(int x) {
        int reversed = 0;
        while (x != 0) {
            int digit = x % 10;
            x = x / 10;
            if (reversed > Integer.MAX_VALUE / 10 ||
                (reversed == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }
            if (reversed < Integer.MIN_VALUE / 10 ||
                (reversed == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }
            reversed = reversed * 10 + digit;
        }
        return reversed;
    }

}
