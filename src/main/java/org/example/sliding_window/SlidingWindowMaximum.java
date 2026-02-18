package org.example.sliding_window;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.TreeSet;

/**
 * task: <a href="https://leetcode.com/problems/sliding-window-median/description/">Sliding Window Median</a><br>
 * difficulty: {@code medium}
 */
public class SlidingWindowMaximum {

    /**
     * time complexity: {@code O(N)}
     * space complexity: {@code O(N)}
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return res;
    }

    /**
     * time complexity: {@code O(N*log(K))}
     * space complexity: {@code O(N)}
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];

        TreeSet<Integer> window = new TreeSet<>((a, b) -> {
            if (nums[a] != nums[b]) {
                return Integer.compare(nums[b], nums[a]);
            }
            return Integer.compare(a, b);
        });

        for (int i = 0; i < nums.length; i++) {
            window.add(i);
            if (i >= k) {
                window.remove(i - k);
            }
            if (i >= k - 1) {
                res[i - k + 1] = nums[window.first()];
            }
        }

        return res;
    }

}
