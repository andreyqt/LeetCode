package org.example.binary_search;

/**
 * task: <a href="https://leetcode.com/problems/minimum-number-of-seconds-to-make-mountain-height-zero/">Minimum Number of Seconds to Make Mountain Height Zero</a><br>
 * time complexity: {@code O(N)}<br>
 * space complexity: {@code O(1)}<br>
 * difficulty: {@code medium}
 */
public class MinNumberOfSteps {

    public long minNumberOfSteps(int mountainHeight, int[] workerTimes) {
        long left = 1, right = (long) 1e18;
        long res = right;

        while (left <= right) {
            long mid = (left + right) / 2;
            if (canFinish(mid, mountainHeight, workerTimes)) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    private boolean canFinish(long time, int mountainHeight, int[] workerTime) {
        long totalWork = 0;
        for (int t : workerTime) {
            long maxK = (long) (Math.sqrt(1 + 8.0 * time / t) - 1) / 2;
            totalWork += maxK;
            if (totalWork >= mountainHeight) return true;
        }
        return totalWork >= mountainHeight;
    }

}
