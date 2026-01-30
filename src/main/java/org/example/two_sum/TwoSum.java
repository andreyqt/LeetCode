package org.example.two_sum;

/**
 * task: <a href="https://leetcode.com/problems/two-sum/description/">Two Sum</a><br>
 * time complexity: {@code O(N^2)}<br>
 * space complexity: {@code O(1)}<br>
 * difficulty: {@code easy}
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] sol = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++)
                if (nums[i] + nums[j] == target) {
                    sol[0] = i;
                    sol[1] = j;
                    return sol;
                }
        }
        return sol;
    }

}
