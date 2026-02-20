package org.example.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * task: <a href="https://leetcode.com/problems/balanced-binary-tree/description/">Balanced Binary Tree</a><br>
 * difficulty: {@code easy}
 */
public class BalancedTree {

    /**
     * time complexity: {@code O(N)}<br>
     * space complexity: {@code O(H)}<br>
     * method: {@code recursive}
     */
    public boolean isBalanced(MyTreeNode node) {
        if (node == null) return true;
        return checkHeight(node) != -1;
    }

    private int checkHeight(MyTreeNode node) {
        if (node == null) return 0;

        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) return -1;

        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    /**
     * time complexity: {@code O(N)}<br>
     * space complexity: {@code O(N)}<br>
     * method: {@code post-order}
     */
    public boolean isBalanced2(MyTreeNode root) {
        if (root == null) return true;

        Stack<MyTreeNode> stack = new Stack<>();
        Map<MyTreeNode, Integer> map = new HashMap<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            MyTreeNode node = stack.pop();
            if (node == null) continue;

            if ((node.left == null || map.containsKey(node.left)) &&
                (node.right == null || map.containsKey(node.right))) {

                int leftHeight = map.getOrDefault(node.left, 0);
                int rightHeight = map.getOrDefault(node.right, 0);

                if (Math.abs(leftHeight - rightHeight) > 1) return false;
                map.put(node, 1 + Math.max(leftHeight, rightHeight));
            } else {
                stack.push(node);
                stack.push(node.left);
                stack.push(node.right);
            }
        }
        return true;
    }

}
