package org.example.parentheses;

import java.util.Stack;

/**
 * task: <a href="https://leetcode.com/problems/valid-parentheses/description/">Valid Parentheses</a><br>
 * time complexity: {@code O(N)}
 * space complexity: {@code O(N)}
 * difficulty: {@code medium}
 */
public class ValidParentheses {

    public boolean validParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
