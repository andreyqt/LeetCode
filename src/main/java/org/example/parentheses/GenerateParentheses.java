package org.example.parentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * task: <a href="https://leetcode.com/problems/valid-parentheses/description/">Valid Parentheses</a><br>
 * time complexity: {@code O(4^N / Sqrt(N))}
 * space complexity: {@code O(N)}
 * difficulty: {@code medium}
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, "", 0,0, n);
        return res;
    }

    private void  backtrack(List<String> res, String current,
                            int open, int close, int max) {
        if (current.length() == max * 2) {
            res.add(current);
            return;
        }

        if (open < max) {
            backtrack(res, current + "(", open + 1, close, max);
        }

        if (close < open) {
            backtrack(res, current + ")", open, close + 1, max);
        }
    }

}
