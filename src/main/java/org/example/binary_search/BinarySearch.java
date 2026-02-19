package org.example.binary_search;

/**
 * task: <a href="https://leetcode.com/problems/binary-search/description/">Binary Search</a><br>
 * time complexity: {@code O(log(N))}<br>
 * space complexity: {@code O(1)}<br>
 * difficulty: {@code easy}
 */
public class BinarySearch {

    public int binary_search(int[] arr, int target) {
        int right = arr.length - 1;
        int left = 0;

        while (left <= right) {
            int mid = left + (right - left)/2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

}
