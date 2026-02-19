package org.example.dfs_bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * task: <a href="https://leetcode.com/problems/remove-invalid-parentheses/description/">Remove Invalid Parentheses</a><br>
 * time complexity: {@code O(2^N)}
 * space complexity: {@code O(2^N)}
 * difficulty: {@code hard}
 */
public class InvalidParentheses {

    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.isEmpty()) return res;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.offer(s);
        visited.add(s);
        boolean found = false;

        while (!queue.isEmpty() && !found) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                String current = queue.poll();

                if (isValid(current)) {
                    res.add(current);
                    found = true;
                }

                if (!found) {
                    for (int j = 0; j < levelSize; j++) {
                        char c = current.charAt(j);

                        if (c != '(' && c != ')') {
                            continue;
                        }

                        String next = current.substring(0, j) + current.substring(j + 1);

                        if (!visited.contains(next)) {
                            queue.offer(next);
                            visited.add(next);
                        }
                    }
                }

            }
        }

        return res;
    }

    private boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            }
            if (c == ')') {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }

}
