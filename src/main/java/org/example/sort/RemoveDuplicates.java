package org.example.sort;

/**
 * task: <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/">RemoveElement Duplicates from Sorted Array</a><br>
 * time complexity: {@code O(N)}
 * space complexity: {@code O(1)}
 * difficulty: {@code easy}
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

}
