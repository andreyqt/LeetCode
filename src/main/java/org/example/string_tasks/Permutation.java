package org.example.string_tasks;

/**
 * task: <a href="https://leetcode.com/problems/permutation-in-string/description/">Permutation in String</a><br>
 * time complexity: {@code O(N+M)}
 * space complexity: {@code O(1)}
 * difficulty: {@code medium}
 */
public class Permutation {

    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if (m < n) {
            return false;
        }

        int[] map1 = new int[26];
        int[] map2 = new int[26];

        for (int i = 0; i < n; i++) {
            map1[s1.charAt(i) - 'a']++;
            map2[s2.charAt(i) - 'a']++;
        }

        if (isMatched(map1, map2)) {
            return true;
        }

        for (int j = 1; j <= m - n; j++) {
            map2[s2.charAt(j - 1) - 'a']--;
            map2[s2.charAt(j + n - 1) - 'a']++;
            if (isMatched(map1, map2)) {
                return true;
            }
        }
        return false;
    }

    private boolean isMatched(int[] map1, int[] map2) {
        for (int i = 0; i < 26; i++) {
            if (map1[i] != map2[i]) {
                return false;
            }
        }
        return true;
    }


}
