package org.example.tree;

/**
 * task: <a href="https://leetcode.com/problems/path-sum/description/">Path Sum I</a><br>
 * time complexity: {@code O(N)}<br>
 * space complexity: {@code O(Log(N))}<br>
 * difficulty: {@code medium}
 */
public class PathSum {

    public boolean hasPathSum(MyTreeNode root, int targetSum) {
        if (root == null) return false;

        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        targetSum -= root.val;

        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }

}
