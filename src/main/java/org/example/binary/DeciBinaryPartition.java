package org.example.binary;

/**
 * task: <a href="https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/">Partitioning Into Minimum Number Of Deci-Binary Numbers</a><br>
 * time complexity: {@code O(N)}<br>
 * space complexity: {@code O(1)}<br>
 * difficulty: {@code medium}
 */
public class DeciBinaryPartition {

    public int minPartition(String n) {
        int minOperations = 0;
        for (int i = 0; i < n.length(); i++) {
            int digit = n.charAt(i) - '0';
            minOperations = Math.max(minOperations, digit);
            if (minOperations == 9) {
                return 9;
            }
        }
        return minOperations;
    }

}
