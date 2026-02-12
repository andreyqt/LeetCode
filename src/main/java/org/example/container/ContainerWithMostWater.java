package org.example.container;

/**
 * task: <a href="https://leetcode.com/problems/container-with-most-water/">Container with Most Water</a><br>
 * difficulty: {@code medium}
 */
public class ContainerWithMostWater {

    /**
     * time complexity: {@code O(N)}<br>
     * space complexity: {@code O(1)}<br>
     */
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, currentArea);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    //brute force
    public int maxAreaTwo(int[] height) {
        int area = 0;
        for (int i = 1; i <= height.length - 1; i++) {
            for (int j = 0; j < i; j++) {
                area = Math.max(area, Math.min(height[j], height[i]) * (i - j));
            }
        }
        return area;
    }

}
