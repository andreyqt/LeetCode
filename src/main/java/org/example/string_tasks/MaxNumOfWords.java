package org.example.string_tasks;

import java.util.Arrays;

/**
 * task: <a href="https://leetcode.com/problems/multiply-strings/description/">Maximum Number of Words Found in Sentences</a><br>
 * time complexity: {@code O(N * M)}<br>
 * space complexity: {@code O(1)}<br>
 * difficulty: {@code easy}
 */
public class MaxNumOfWords {

    public int mostWordsFound(String[] sentences) {
        int max = 0;
        for (String sentence : sentences) {
            int count = 1;
            for (int i = 0; i < sentence.length(); i++) {
                if (sentence.charAt(i) == ' ') count++;
            }
            max = Math.max(count, max);
        }
        return max;
    }

    public int mostWordsFound2(String[] sentences) {
        return Arrays.stream(sentences)
                .mapToInt(sentence -> sentence.split(" ").length)
                .max()
                .orElse(0);
    }

}
