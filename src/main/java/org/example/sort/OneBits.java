package org.example.sort;

import java.util.Arrays;

/**
 * task: <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/">RemoveElement Duplicates from Sorted Array</a><br>
 * time complexity: {@code O(N*Log(N))}<br>
 * space complexity: {@code O(N)}<br>
 * difficulty: {@code medium}
 */
public class OneBits {

    public int[] sortByOneBits(int[] arr) {
        return Arrays.stream(arr)
                .boxed()
                .sorted((a, b) -> {
                    int bitCompare = Integer.bitCount(a) - Integer.bitCount(b);
                    return bitCompare == 0 ? a - b : bitCompare;
                })
                .mapToInt(Integer::intValue)
                .toArray();
    }

}
