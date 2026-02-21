package org.example.two_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ThreeSum {

    /**
     * task: <a href="https://leetcode.com/problems/3sum/">3Sum</a><br>=
     * time complexity: {@code O(N^2)}
     * space complexity: {@code O(1) or O(N) if we count the result}
     * difficulty: {@code medium}
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        if (nums[0]>0) return res;

        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i] == nums[i-1]) continue;

            if (i>1) {
                if (nums[i] > 0 && nums[i-1]>0 && nums[i-2]>0) return res;
            }

            int left = i + 1, right = nums.length - 1;

            while (left < right) {

                if (nums[i] + nums[left] + nums[right] == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left+1]) left++;
                    while (left < right && nums[right] == nums[right-1]) right--;
                    left++;
                    right--;

                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else {
                    right--;
                }

            }
        }
        return res;
    }

    /**
     * task: <a href="https://leetcode.com/problems/3sum-closest/description/">3Sum Closest</a><br>=
     * time complexity: {@code O(N^2)}
     * space complexity: {@code O(1)}
     * difficulty: {@code medium}
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int closest = nums[0] + nums[1] + nums[2];

        for (int i = 1; i < n-2; i++) {
            int left = 0, right = n-1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == target) {
                    return sum;
                }

                if (Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }

                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return closest;
    }

}
