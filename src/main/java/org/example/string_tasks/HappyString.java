package org.example.string_tasks;

/**
 * task: <a href="https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/">The k-th Lexicographical String of All Happy Strings of Length n</a><br>
 * time complexity: {@code O(n)}<br>
 * space complexity: {@code O(n)}<br>
 * difficulty: {@code medium}
 */
public class HappyString {

    public String getHappyString(int n, int k) {
        int num = 3 * (1 << (n - 1));
        if (k > num) return "";

        StringBuilder sb = new StringBuilder();
        char[] happyChars = {'a', 'b', 'c'};

        int prevIdx = -1;
        int remaining = k;

        for (int position = 0; position < n; position++) {
            int blockSize = 1 << (n - position - 1);

            for (int charIdx = 0; charIdx < 3; charIdx++) {
                if (charIdx == prevIdx) continue;

                if (remaining > blockSize) {
                    remaining -= blockSize;
                } else {
                    sb.append(happyChars[charIdx]);
                    prevIdx = charIdx;
                    break;
                }

            }
        }

        return sb.toString();
    }

}
