package org.example.subarray_equals_k;

import java.util.HashMap;
import java.util.Map;

/**
 * task: <a href="https://leetcode.com/problems/subarray-sum-equals-k/description/">Subarray Sum Equals K</a><br>
 * time complexity: {@code O(N)}<br>
 * space complexity: {@code O(N)}<br>
 * difficulty: {@code medium}
 */
public class SubArrayEqualsK {

    public int subArrayEquals(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int total = 0, count = 0;
        for(int n : nums) {
            total += n;

            if (map.containsKey(total-k)) {
                count += map.get(total-k);
            }

            map.put(total, map.getOrDefault(total, 0) + 1);
        }
        return count;
    }

}
