package org.example.single_number;

import java.util.Arrays;

/**
 * task: <a href="https://leetcode.com/problems/single-number/"/>Single Integer</a><br>
 * time complexity: {@code O(N)}
 * space complexity: {@code O(1)}
 * difficulty: {@code easy}
 */
public class SingleInteger {

    public int singleNumber(int[] nums) {
       int result = 0;
       for (int num : nums) {
           result ^= num;
       }
       return result;
    }

}
