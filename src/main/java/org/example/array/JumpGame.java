package org.example.array;

/**
 * task: <a href="https://leetcode.com/problems/can-place-flowers/">Can Place Flowers</a><br>
 * time complexity: {@code O(n)}<br>
 * space complexity: {@code O(1)}<br>
 * difficulty: {@code easy}
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        int maxReachable = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReachable) {
                return false;
            }
            maxReachable = Math.max(maxReachable, i + nums[i]);
        }
        return true;
    }

}
