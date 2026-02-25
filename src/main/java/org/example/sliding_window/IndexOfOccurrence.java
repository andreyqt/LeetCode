package org.example.sliding_window;

/**
 * task: <a href="https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/">Find the Index of the First Occurrence in a String</a><br>
 * time complexity: {@code O(N * M)}
 * space complexity: {@code O(1)}
 * difficulty: {@code medium}
 */
public class IndexOfOccurrence {

    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if (n == 0) return 0;
        if (m == 0 || n < m) return -1;

        for (int i = 0; i <= n - m; i++) {
            boolean found = true;

            for (int j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    found = false;
                    break;
                }
            }
            if (found) return i;

        }
        return -1;
    }

}
