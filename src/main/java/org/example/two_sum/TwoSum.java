package org.example.two_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * task: <a href="https://leetcode.com/problems/two-sum/description/">Two Sum</a><br>=
 * difficulty: {@code easy}
 */
public class TwoSum {

    /*
     * time complexity: {@code O(N^2)}<br>
     * space complexity: {@code O(1)}<br>
     * brute force
     */
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

    /*
     * time complexity: {@code O(N)}<br>
     * space complexity: {@code O(N)}<br>
     * the best
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    /*
     * time complexity: {@code O(N)}<br>
     * space complexity: {@code O(1)}<br>
     * for sorted array
     *
     */
    public int[] twoSum3(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left, right};
            }
            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{};
    }

}
