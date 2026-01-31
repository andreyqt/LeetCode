package org.example.bitwise_parity;

/**
 * task: from interview<br>
 * time complexity: {@code O(n)}<br>
 * space complexity: {@code O(1)}<br>
 * difficulty: {@code easy}
 */
public class BitwiseOrParity {

    public boolean isEven(int[] nums) {
        for (int num : nums) {
            if (num % 2 != 0) {
                return false;
            }
        }
        return true;
    }

}
