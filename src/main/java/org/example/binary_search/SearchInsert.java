package org.example.binary_search;

/**
 * task: <a href="https://leetcode.com/problems/search-insert-position/description/">Search Insert Position</a><br>
 * time complexity: {@code O(Log(N))}<br>
 * space complexity: {@code O(1)}<br>
 * difficulty: {@code easy}
 */
public class SearchInsert {

    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

}
