package org.example.binary;

/**
 * task: <a href="https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/">Concatenation of Consecutive Binary Numbers</a><br>
 * time complexity: {@code O(N)}<br>
 * space complexity: {@code O(1)}<br>
 * difficulty: {@code medium}
 */
public class ConcatenationOfBinary {

    public int concatenatedBinary(int n) {
        int mod = 1000000007, bits = 0;
        long result = 0;

        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                bits++;
            }
            result = ((result << bits) + i) % mod;
        }

        return (int) result;
    }

}
