package org.example.integer;

/**
 * task: <a href="https://leetcode.com/problems/remove-element/description/">Remove Element</a><br>
 * time complexity: {@code O(N)}<br>
 * space complexity: {@code O(1)}<br>
 * difficulty: {@code easy}
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

}
