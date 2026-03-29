package org.example.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * task: <a href="https://leetcode.com/problems/combination-sum/description/">Combination Sum</a><br>
 * time complexity: {@code O(2 ^ target)}<br>
 * space complexity: {@code O(target)}<br>
 * difficulty: {@code medium}
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] candidates,
                           int remain, int start) {
        if (remain < 0) return;

        if (remain == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            tempList.add(candidates[i]);
            backtrack(result, tempList, candidates, remain - candidates[i], i);
            tempList.remove(tempList.size() - 1);
        }
    }

}
