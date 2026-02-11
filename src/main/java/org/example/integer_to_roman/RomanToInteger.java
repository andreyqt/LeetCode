package org.example.integer_to_roman;

import java.util.HashMap;
import java.util.Map;

/**
 * task: <a href="https://leetcode.com/problems/roman-to-integer/description/">Roman to Integer</a><br>
 * time complexity: {@code O(n)}<br>
 * space complexity: {@code O(1)}<br>
 * difficulty: {@code medium}
 */
public class RomanToInteger {

    public int romanToInt(String s) {
        int[] ints = {1000, 500, 100, 50, 10, 5, 1};
        Character[] chars = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], ints[i]);
        }

        int res = 0;
        int prev = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int current = map.get(s.charAt(i));

            if (current >= prev) {
                res = res + current;
            } else {
                res = res - current;
            }
            prev = current;

        }

        return res;
    }

}
