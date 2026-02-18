package org.example.sliding_window;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * task: <a href="https://leetcode.com/problems/sliding-window-median/description/">Sliding Window Median</a><br>
 * difficulty: {@code medium}
 */
public class SlidingWindowMedian {

    /**
     * time complexity: O(N*log(k))
     * space complexity: O(k)
     */
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] res = new double[n - k + 1];

        TreeSet<Integer> left = new TreeSet<>((a, b) -> {
            if (nums[a] != nums[b]) {
                return Integer.compare(nums[b], nums[a]);
            }
            return Integer.compare(a, b);
        });

        TreeSet<Integer> right = new TreeSet<>((a, b) -> {
            if (nums[a] != nums[b]) {
                return Integer.compare(nums[a], nums[b]);
            }
            return Integer.compare(a, b);
        });

        for (int i = 0; i < n; i++) {
            if (left.isEmpty() || nums[i] <= nums[left.first()]) {
                left.add(i);
            } else {
                right.add(i);
            }

            if (i >= k) {
                if (left.contains(i - k)) {
                    left.remove(i - k);
                } else {
                    right.remove(i - k);
                }
            }

            balance(left, right);
            if (i >= k - 1) {
                if (left.size() > right.size()) {
                    res[i - k + 1] = nums[left.first()];
                } else {
                    long a = nums[left.first()];
                    long b = nums[right.first()];
                    res[i - k + 1] = (a + b) / 2.0;
                }
            }

        }

        return res;
    }

    private void balance(TreeSet<Integer> left, TreeSet<Integer> right) {
        while (left.size() > right.size() + 1) {
            int idx = left.first();
            left.remove(idx);
            right.add(idx);
        }
        while (right.size() > left.size()) {
            int idx = right.first();
            right.remove(idx);
            left.add(idx);
        }
    }

    /**
     * time complexity: O(N*k*log(k))
     * space complexity: O(N*k)
     */
    public double[] medianSlidingWindow2(int[] nums, int k) {
        int left = 0, right = k - 1;
        double[] res = new double[nums.length - k + 1];
        boolean isOdd = (k % 2 == 1);
        for (int i = 0; i < nums.length - k + 1; i++) {
            int[] section = Arrays.copyOfRange(nums, left, right + 1);
            Arrays.sort(section);
            if (isOdd) {
                res[i] = section[(k - 1) / 2] * 1.0;
            } else {
                int mid = (k - 1) / 2;
                res[i] = ((long) section[mid] + (long) section[mid + 1]) / 2.0;
            }
            left++;
            right++;
        }
        return res;
    }
}
