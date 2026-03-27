package org.example.string_tasks;

/**
 * task: <a href="https://leetcode.com/problems/count-and-say/description/">Count and Say</a><br>
 * time complexity: {@code O(N * M)}<br>
 * space complexity: {@code O(M)}<br>
 * difficulty: {@code medium}
 */
public class CountAndSay {

    public String countAndSay(int n) {
        String result = "1";

        for (int i = 1; i < n; i++) {
            StringBuilder next = new StringBuilder();
            int count = 1;

            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == result.charAt(j-1)) {
                    count++;
                } else {
                    next.append(count).append(result.charAt(j-1));
                    count = 1;
                }
            }
            next.append(count).append(result.charAt(result.length() - 1));
            result = next.toString();
        }

        return result;
    }

}
