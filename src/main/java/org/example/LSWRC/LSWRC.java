package org.example.LSWRC;

import java.util.ArrayList;
import java.util.List;

/**
 * task: <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters"/>Longest Substring Without Repeating Characters</a><br>
 * time complexity: {@code O(N^2)}<br>
 * space complexity: {@code O(min(n, m))}<br>
 * difficulty: {@code easy}
 */
public class LSWRC {

    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        List<Character> sub = new ArrayList<>();
        for (int i=0; i<s.length(); i++) {
            if (sub.contains(s.charAt(i))) {
                res = Math.max(res, sub.size());
                int removeIndex = sub.indexOf(s.charAt(i));
                for (int j=0; j<= removeIndex; j++) {
                    sub.remove(0);
                }
                sub.add(s.charAt(i));
            } else {
                sub.add(s.charAt(i));
            }
        }
        return Math.max(res, sub.size());
    }

}
