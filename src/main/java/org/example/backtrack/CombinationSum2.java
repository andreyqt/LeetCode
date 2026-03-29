package org.example.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * task: <a href="https://leetcode.com/problems/combination-sum-ii/description/">Combination Sum II</a><br>
 * time complexity: {@code O(2 ^ target)}<br>
 * space complexity: {@code O(target)}<br>
 * difficulty: {@code medium}
 */
public class CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(result, new ArrayList<Integer>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList,
                           int[] candidates, int remain, int start) {
        if (remain < 0) return;
        if (remain == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i-1]) continue;
            tempList.add(candidates[i]);
            backtrack(result, tempList, candidates, remain - candidates[i], i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

}
