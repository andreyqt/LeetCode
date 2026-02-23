package org.example.integer;

/**
 * task: <a href="https://leetcode.com/problems/divide-two-integers/">Divide Two Integers</a><br>
 * time complexity: {@code O(Log^2(N))}<br>
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

        int result = 0;
        while (dvd >= dvs) {
            long tmp = dvs;
            long multiple = 1;
            while (dvd >= (tmp << 1)) {
                tmp <<= 1;
                multiple <<= 1;
            }
            dvd -= tmp;
            result += multiple;
        }

        return negative ? -result : result;
    }

}
