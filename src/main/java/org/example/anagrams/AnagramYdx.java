package org.example.anagrams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * task: <a href="https://coderun.yandex.ru/selections/yandex-interview/problems/anagrams">Anagrams</a><br>
 * time complexity: {@code O(N)}
 * space complexity: {@code O(1)}
 * difficulty: {@code medium}
 */
public class AnagramYdx {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String first = reader.readLine();
        String second = reader.readLine();
        reader.close();

        int[] charStats = new int[26];
        for (int i = 0; i < first.length(); i++) {
            charStats[first.charAt(i) - 'a']++;
        }

        for (int i = 0; i < second.length(); i++) {
            if (charStats[second.charAt(i) - 'a'] == 0) {
                writer.write("0");
                writer.close();
                return;
            }
            charStats[second.charAt(i) - 'a']--;
            if (charStats[second.charAt(i) - 'a'] < 0) {
                writer.write("0");
                writer.close();
                return;
            }
        }

        writer.write("1");
        writer.close();
    }

}
