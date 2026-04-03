package org.example.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * task: <a href="https://leetcode.com/problems/permutations-ii/description/">Permutations II</a><br>
 * time complexity: {@code O(n * n!)}<br>
 * space complexity: {@code O(n * n!)}<br>
 * difficulty: {@code medium}
 */
public class Permutations2 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, boolean[] used) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
            used[i] = true;
            tempList.add(nums[i]);
            backtrack(result, tempList, nums, used);
            tempList.remove(tempList.size() - 1);
            used[i] = false;
        }
    }

}
