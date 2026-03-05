package org.example.string_tasks;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * task: <a href="https://leetcode.com/problems/3sum-closest/description/">Letter Combinations of a Phone Number</a><br>=
 * time complexity: {@code O(N * 4^N)}<br>
 * space complexity: {@code O(N * 4^N)}<br>
 * difficulty: {@code medium}
 */
public class PhoneNumber {

    public List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList<>();
        if (digits.isEmpty()) return result;

        Map<Character, String> mappings = new HashMap<>();
        mappings.put('2', "abc");
        mappings.put('3', "def");
        mappings.put('4', "ghi");
        mappings.put('5', "jkl");
        mappings.put('6', "mno");
        mappings.put('7', "pqrs");
        mappings.put('8', "tuv");
        mappings.put('9', "wxyz");

        result.add("");
        for (int i = 0; i < digits.length(); i++) {
            String letter = mappings.get(digits.charAt(i));
            int size = result.size();

            for (int j = 0; j < size; j++) {
                String combination = result.poll();
                for (char ch : letter.toCharArray()) {
                    result.add(combination + ch);
                }
            }
        }

        return result;
    }

}
