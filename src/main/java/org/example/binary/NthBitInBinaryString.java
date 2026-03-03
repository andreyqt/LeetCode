package org.example.binary;

/**
 * task: <a href="https://leetcode.com/problems/find-kth-bit-in-nth-binary-string">Find Kth Bit in Nth Binary String</a><br>
 * time complexity: {@code O(N)}<br>
 * space complexity: {@code O(N)}<br>
 * difficulty: {@code medium}
 */
public class NthBitInBinaryString {

    public char findKthBit(int n, int k) {
        if (n == 1) return '0';

        int length = (1 << n) - 1;
        int mid = length / 2 + 1;

        if (k == mid) return '1';

        else if (k < mid) {
            return findKthBit(n - 1, k);
        }

        else {
            int idx = 2 * mid - k;
            char bit = findKthBit(n - 1, idx);
            return bit == '0' ? '1' : '0';
        }
    }

}
