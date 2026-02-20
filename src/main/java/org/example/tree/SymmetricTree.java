package org.example.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * task: <a href="https://leetcode.com/problems/symmetric-tree/description/">Symmetric Tree</a><br>
 * difficulty: {@code easy}
 */
public class SymmetricTree {

    /**
     * time complexity: {@code O(N)}<br>
     * space complexity: {@code O(H)}<br>
     * method: {@code recursive}
     */
    public boolean isSymmetric(MyTreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(MyTreeNode left, MyTreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val &&
               isMirror(left.left, left.right) &&
               isMirror(right.left, right.right);
    }

    /**
     * time complexity: {@code O(N)}<br>
     * space complexity: {@code O(N)}<br>
     * method: {@code bfs}
     */
    public boolean isSymmetric2(MyTreeNode root) {
        if (root == null) return true;

        Queue<MyTreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            MyTreeNode left = queue.poll();
            MyTreeNode right = queue.poll();

            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;

            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }

    /**
     * time complexity: {@code O(N)}<br>
     * space complexity: {@code O(H)}<br>
     * method: {@code dfs}
     */
    public boolean isSymmetric3(MyTreeNode root) {
        if (root == null) return true;

        Stack<MyTreeNode[]> stack = new Stack<>();
        stack.push(new MyTreeNode[]{root.left, root.right});

        while (!stack.isEmpty()) {
            MyTreeNode[] pair = stack.pop();
            MyTreeNode left = pair[0];
            MyTreeNode right = pair[1];

            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;

            stack.push(new MyTreeNode[]{left.left, right.right});
            stack.push(new MyTreeNode[]{left.right, right.left});
        }
        return true;
    }

}
