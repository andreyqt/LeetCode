package org.example.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * task: <a href="https://leetcode.com/problems/same-tree/description/">Same Tree</a><br>
 * difficulty: {@code easy}
 */
public class SameTree {

    /**
     * time complexity: {@code O(N)}<br>
     * space complexity: {@code O(H)}<br>
     * method: {@code recursive}<br>
     */
    public boolean isSameTree(MyTreeNode p, MyTreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /**
     * time complexity: {@code O(N)}<br>
     * space complexity: {@code O(N)}<br>
     * method: bfs<br>
     */
    public boolean isSameTree2(MyTreeNode p, MyTreeNode q) {
        Queue<MyTreeNode[]> queue = new LinkedList<>();
        queue.offer(new MyTreeNode[]{p, q});

        while (!queue.isEmpty()) {
            MyTreeNode[] pair = queue.poll();
            MyTreeNode left = pair[0];
            MyTreeNode right = pair[1];

            if (left == null && right == null) continue;
            if (left == null || right == null || left.val != right.val) return false;

            queue.offer(new MyTreeNode[]{left.left, left.right});
            queue.offer(new MyTreeNode[]{right.left, right.right});
        }
        return true;
    }

    /**
     * time complexity: {@code O(N)}<br>
     * space complexity: {@code O(H)}<br>
     * method: dfs<br>
     */
    public boolean isSameTree3(MyTreeNode p, MyTreeNode q) {
        Stack<MyTreeNode[]> stack = new Stack<>();
        stack.push(new MyTreeNode[]{p, q});

        while (!stack.isEmpty()) {
            MyTreeNode[] pair = stack.pop();
            MyTreeNode left = pair[0];
            MyTreeNode right = pair[1];

            if (left == null && right == null) continue;
            if (left == null || right == null || left.val != right.val) return false;

            stack.push(new MyTreeNode[]{left.left, right.right});
            stack.push(new MyTreeNode[]{right.left, right.right});
        }
        return true;
    }
}
