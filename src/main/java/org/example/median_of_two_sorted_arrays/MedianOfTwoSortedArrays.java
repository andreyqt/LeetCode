package org.example.median_of_two_sorted_arrays;

/**
 * task: <a href="https://leetcode.com/problems/median-of-two-sorted-arrays/"/>Median of Two Sorted Arrays</a><br>
 * time complexity: {@code O(log(min(n, m)))}<br>
 * space complexity: {@code O(1)}<br>
 * difficulty: {@code hard}
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] a, int[] b) {
        int n = a.length, m = b.length;
        if (n > m)
            return findMedianSortedArrays(b, a);

        int left = 0, right = n;
        while (left <= right) {
            int mid1 = (left + right) / 2;
            int mid2 = (n + m + 1) / 2 - mid1;

            int l1 = (mid1 == 0) ? Integer.MIN_VALUE : a[mid1 - 1];
            int r1 = (mid1 == n) ? Integer.MAX_VALUE : a[mid1];
            int l2 = (mid2 == 0) ? Integer.MIN_VALUE : b[mid2 - 1];
            int r2 = (mid2 == m) ? Integer.MAX_VALUE : b[mid2];

            if (l1 <= r2 && l2 <= r1) {
                if ((n + m) % 2 == 0)
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                else
                    return Math.max(l1, l2);
            }
            if (l1 > r2)
                right = mid1 - 1;
            else
                left = mid1 + 1;
        }
        return 0;
    }

}
