package org.example.integer;

/**
 * task: <a href="https://leetcode.com/problems/palindrome-number/">Palindrome Number</a><br>
 * difficulty: {@code easy}
 */
public class PalindromeNumber {

    /**
     * time complexity: {@code O(n)}<br>
     * space complexity: {@code O(n)}<br>
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String str = String.valueOf(x);
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - i - 1]) {
                return false;
            } else {
                continue;
            }
        }
        return true;
    }

    /**
     * time complexity: {@code O(log_10(n))}<br>
     * space complexity: {@code O(1)}<br>
     */
    public boolean isPalindrome2(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int given = x;
        int reversed = 0;
        while (x > 0) {
            reversed = reversed * 10 + x % 10;
            x = x / 10;
        }
        return reversed == given;
    }

}
