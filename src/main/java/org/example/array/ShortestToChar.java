package org.example.array;

/**
 * task: <a href="https://leetcode.com/problems/shortest-distance-to-a-character/description/">Shortest Distance to a Character</a><br>
 * time complexity: {@code O(N)}<br>
 * space complexity: {@code O(N)}<br>
 * difficulty: {@code easy}
 */
public class ShortestToChar {

    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] res = new int[n];

        int prev = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                prev = i;
            } else {
                res[i] = i - prev;
            }
        }

        prev = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                prev = i;
            } else {
                res[i] = Math.min(res[i], prev - i);
            }
        }
        return res;
    }

}
