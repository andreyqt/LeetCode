package org.example.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * task: <a href="https://leetcode.com/problems/permutations/description/">Permutations</a><br>
 * time complexity: {@code O(n * n!)}<br>
 * space complexity: {@code O(n * n!)}<br>
 * difficulty: {@code medium}
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums, boolean[] used) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp)); // make a copy
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            used[i] = true;
            temp.add(nums[i]);

            backtrack(result, temp, nums, used);

            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }
}
