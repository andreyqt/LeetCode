package org.example.string_tasks;

/**
 * task: <a href="https://leetcode.com/problems/longest-common-prefix/description/">Longest Common Prefix</a><br>
 * difficulty: {@code easy}
 */
public class LongestCommonPrefix {

    /**
     * time complexity: {@code O(N)}
     * space complexity: {@code O(1)}
     */
    public String longestCommonPrefix(String[] strings) {
        if (strings.length == 0) return "";

        for (int i = 0; i < strings[0].length(); i++){
            char currentChar = strings[0].charAt(i);

            for (int j = 1; j < strings.length; j++) {
                if (i >= strings[j].length() || strings[j].charAt(i) != currentChar) {
                    return strings[0].substring(0,i);
                }
            }

        }
        return strings[0];
    }

    /**
     * time complexity: {@code O(N)}
     * space complexity: {@code O(N)}
     */
    public String longestCommonPrefix2(String[] strings) {
        if (strings.length == 0) return "";

        TrieNode root = new TrieNode();
        for (String string : strings) {
            if (string.isEmpty()) return "";
            insert(root, string);
        }

        StringBuilder prefix = new StringBuilder();
        TrieNode current = root;

        while (current.children.size() == 1 && !current.isEnd) {
            char nextChar = current.children.keySet().iterator().next();
            prefix.append(nextChar);
            current = current.children.get(nextChar);
        }

        return prefix.toString();
    }

    private void insert(TrieNode root, String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            current.children.putIfAbsent(c, new TrieNode());
            current = current.children.get(c);
        }
        current.isEnd = true;
    }

}
