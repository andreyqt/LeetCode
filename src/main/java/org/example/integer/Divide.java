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

        boolean sign = (dividend < 0) ^ (divisor < 0);

        int res = 0;
        int dvd = dividend > 0 ? -dividend : dividend;
        int dvs = divisor > 0 ? -divisor : divisor;

        while (dvd <= dvs) {
            int temp = dvs;
            int count = 1;
            while (temp >= Integer.MIN_VALUE / 2 && dvd <= (temp << 1)) {
                temp <<= 1;
                count <<= 1;
            }
            dvd -= temp;
            res += count;
        }

        return sign ? -res : res;
    }

}
