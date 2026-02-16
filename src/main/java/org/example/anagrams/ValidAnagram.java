package org.example.anagrams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * task: <a href="https://leetcode.com/problems/valid-anagram/">Valid Anagrams</a><br>
 * difficulty: {@code medium}
 */
public class ValidAnagram {

    /**
     * time complexity: {@code O(n)}<br>
     * space complexity: {@code O(k)}<br>
     */
    public boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length(); i ++) {
            map.put(a.charAt(i), map.getOrDefault(a.charAt(i), 0) + 1);
            map.put(b.charAt(i), map.getOrDefault(b.charAt(i), 0) - 1);
        }
        for (int i : map.values()) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * time complexity: {@code O(n*log(n))}<br>
     * space complexity: {@code O(n)}<br>
     */
    public boolean isAnagram2(String a, String b) {
        char[] arr1 = a.toCharArray();
        char[] arr2 = b.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    /**
     * time complexity: {@code O(n)}<br>
     * space complexity: {@code O(1)}<br>
     */
    public boolean isAnagram3(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        int[] counts = new int[26];
        for (int i = 0; i < a.length(); i ++) {
            counts[a.charAt(i) - 'a']++;
            counts[b.charAt(i) - 'a']--;
        }
        for (int c : counts) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }

}
