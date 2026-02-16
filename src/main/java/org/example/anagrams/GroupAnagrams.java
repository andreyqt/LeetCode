package org.example.anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * task: <a href="https://leetcode.com/problems/group-anagrams/description/">Group Anagrams</a><br>
 * time complexity: {@code O(N*k*log(k))}<br>
 * space complexity: {@code O(n*k)}<br>
 * difficulty: {@code medium}
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strings) {
        Map<String, List<String>> res = new HashMap<>();
        for (String s : strings) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (!res.containsKey(key)) {
                res.put(key, new ArrayList<>());
            }
            res.get(key).add(s);
        }
        return new ArrayList<>(res.values());
    }

}
