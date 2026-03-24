package org.example.binary_search;

/**
 * task: <a href="https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/">Find First and Last Position of Element in Sorted Array</a><br>
 * difficulty: {@code medium}
 */
public class FirstAndLast {

    /**
     * time complexity: {@code O(N)}<br>
     * space complexity: {@code O(1)}<br>
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};

        int left = 0, right = nums.length - 1;
        int[] res = new int[2];

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                res[0] = mid;
                res[1] = mid;
                while (mid + 1 < nums.length && nums[mid + 1] == target) {
                    res[1] = mid + 1;
                    mid++;
                }
                while (mid - 1 >= 0 && nums[mid - 1] == target) {
                    res[0] = mid - 1;
                    mid--;
                }
                return res;
            }

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return new int[]{-1, -1};
    }

    /**
     * time complexity: {@code O(Log(N))}<br>
     * space complexity: {@code O(1)}<br>
     */
    public int[] searchRange2(int[] nums, int target) {
        int left = findBound(nums, target, true);
        int right = findBound(nums, target, false);
        return new int[]{left, right};
    }

    private int findBound(int[] nums, int target, boolean findFirst) {
        int left = 0, right = nums.length - 1;
        int bound = - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                bound = mid;
                if (findFirst) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return bound;
    }

}
