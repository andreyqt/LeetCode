package org.example.two_pointers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * task: <a href="https://coderun.yandex.ru/selections/yandex-interview/problems/consecutive-ones">Consecutive Ones</a><br>
 * time complexity: {@code O(N)}
 * space complexity: {@code O(N)}
 * difficulty: {@code easy}
 */
public class ConsOnesYdx {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(reader.readLine());
        }

        String s = builder.toString();

        int maxCount = 0;
        int curCount = 0;
        for (int right = 0; right < n; right++) {
            if (s.charAt(right) == '1') {
                curCount++;
                maxCount = Math.max(maxCount, curCount);
            } else {
                curCount = 0;
            }
        }

        writer.write(String.valueOf(maxCount));
        reader.close();
        writer.close();
    }

}
