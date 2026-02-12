package org.example.sort;

import java.util.Arrays;

/**
 * task: <a href="https://leetcode.com/problems/squares-of-a-sorted-array/description/">https://leetcode.com/problems/squares-of-a-sorted-array/description/</a><br>
 * difficulty: {@code easy}
 */
public class SquaresOfSortedArray {

    public int[] squaresOfSortedArray(int[] nums) {
        return Arrays.stream(nums).map(num -> num * num).sorted().toArray();
    }

    /**
     * time complexity: {@code O(N)}<br>
     * space complexity: {@code O(N)}<br>
     */
    public int[] squaresOfSortedArray2(int[] nums) {
        int n = nums.length, left = 0, right = n - 1;
        int[] res = new int[n];
        int idx = n - 1;
        while (left <= right) {
            int lq = nums[left] * nums[left];
            int rq = nums[right] * nums[right];
            if (lq > rq) {
                res[idx] = lq;
                left++;
            } else {
                res[idx] = rq;
                right--;
            }
            idx--;
        }
        return res;
    }

}
