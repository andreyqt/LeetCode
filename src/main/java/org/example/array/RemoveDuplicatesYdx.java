package org.example.array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * task: <a href="https://coderun.yandex.ru/selections/yandex-interview/problems/removing-duplicates">Remove Duplicates</a><br>
 * time complexity: {@code O()}
 * space complexity: {@code O()}
 * difficulty: {@code easy}
 */
public class RemoveDuplicatesYdx {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int len = Integer.parseInt(reader.readLine());

        if (len == 0) {
            writer.close();
            return;
        }

        int prev = Integer.parseInt(reader.readLine());
        writer.write(String.valueOf(prev));

        for (int i = 1; i < len; i++) {
            int cur = Integer.parseInt(reader.readLine());

            if (cur != prev) {
               writer.newLine();
               writer.write(String.valueOf(cur));
            }
            prev = cur;
        }

        reader.close();
        writer.close();
    }

}
