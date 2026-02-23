package org.example.integer;

/**
 * task: <a href="https://leetcode.com/problems/divide-two-integers/">Divide Two Integers</a><br>
 * time complexity: {@code O(Log(N))}<br>
 * space complexity: {@code O(1)}<br>
 * difficulty: {@code medium}
 */
public class Divide {

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean negative = (dividend < 0) ^ (divisor < 0);
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

        long result = 0;
        int shift = 0;
        while (dvd >= (dvs << shift)) {
            shift++;
        }
        shift--;

        while (shift >= 0) {
            dvd -= (dvs << shift);
            result += 1L << shift;
            shift--;
        }

        if (negative) {
            return (int) -result;
        } else {
            if (result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else {
                return (int) result;
            }
        }

    }

}
