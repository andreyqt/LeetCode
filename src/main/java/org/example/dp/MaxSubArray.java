package org.example.dp;

/**
 * task: <a href="https://leetcode.com/problems/maximum-subarray/description/">Maximum Subarray</a><br>
 * time complexity: {@code O(N)}<br>
 * space complexity: {@code O(1)}<br>
 * difficulty: {@code hard}
 */
public class MaxSubArray {

    //Kadane algorithm
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    //dynamic programming (requires O(N) additional memory)
    public int maxSubArray2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int maxSum = dp[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum;
    }


}
