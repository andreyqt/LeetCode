package org.example.container;

/**
 * task: <a href="https://leetcode.com/problems/trapping-rain-water/description/>Trapping Rain Water</a><br>
 * time complexity: {@code O(N)}
 * space complexity: {@code O(1)}
 * difficulty: {@code hard}
 */
public class TrappingWaterContainer {

    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;

        int left = 0, right = height.length - 1;
        int leftMax = height[left], rightMax = height[right];
        int totalWater = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                totalWater += leftMax- height[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                totalWater += rightMax- height[right];
            }
        }
        return totalWater;
    }

}
