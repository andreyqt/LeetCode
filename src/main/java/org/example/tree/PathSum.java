package org.example.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * task: <a href="https://leetcode.com/problems/path-sum-ii/description/">Path Sum II</a><br>
 * time complexity: {@code O(N^2)}<br>
 * space complexity: {@code O(N*Log(N))}<br>
 * difficulty: {@code medium}
 */
public class PathSum {

    public List<List<Integer>> pathSum(MyTreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        dfs(root, sum, current, result);
        return result;
    }

    private void dfs(MyTreeNode node, int remainingSum, List<Integer> currentSum,
                     List<List<Integer>> result) {
        if (node == null) {return;}

        currentSum.add(node.val);
        if (node.left == null && node.right == null && remainingSum == node.val) {
            result.add(new ArrayList<>(currentSum));
        } else {
            dfs(node.left, remainingSum - node.val, currentSum, result);
            dfs(node.right, remainingSum - node.val, currentSum, result);
        }
        currentSum.remove(currentSum.size() - 1);
    }

}
