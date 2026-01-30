package org.example.longest_palindromic_substring;

/**
 * task: <a href="https://leetcode.com/problems/longest-palindromic-substring/description/"/>Longest Palindromic Substring</a><br>
 * time complexity: {@code O(n^2)}<br>
 * space complexity: {@code O(n)}<br>
 * difficulty: {@code medium}
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty())
            return "";
        String longest = "";
        for (int i = 0; i < s.length(); i++) {

            String odd = expand(s, i, i);
            if (odd.length() > longest.length()) {
                longest = odd;
            }

            String even = expand(s, i, i + 1);
            if (even.length() > longest.length()) {
                longest = even;
            }
        }
        return longest;
    }

    private String expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

}
