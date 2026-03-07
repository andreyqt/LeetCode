package org.example.string_tasks;

/**
 * task: <a href="https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones">Check if Binary String Has at Most One Segment of Ones</a><br>
 * time complexity: {@code O(N)}<br>
 * space complexity: {@code O(1)}<br>
 * difficulty: {@code easy}
 */
public class CheckSegment {

    public boolean checkOnesSegment(String s) {
        if (s.isEmpty()) return false;

        int lastIdx = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                if (i - lastIdx > 1) {
                    return false;
                } else {
                    lastIdx = i;
                }
            }
        }
        return true;
    }

}
