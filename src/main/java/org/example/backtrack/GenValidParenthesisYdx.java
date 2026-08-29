package org.example.backtrack;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * task: <a href="https://coderun.yandex.ru/selections/yandex-interview/problems/generating-bracket-sequences">Generate Valid Parenthesis</a><br>
 * time complexity: {@code O(N * N-th Catalan's Number)}
 * space complexity: {@code O(N)}
 * difficulty: {@code medium}
 */
public class GenValidParenthesisYdx {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        reader.close();

        StringBuilder res = new StringBuilder();
        backtrack(res, writer, 0, 0, n);
        writer.close();
    }

    private static void backtrack(StringBuilder cur, BufferedWriter writer,
                                  int openCnt, int closeCnt, int length) throws IOException {
        if (cur.length() == 2 * length) {
            writer.write(cur.toString());
            writer.newLine();
            return;
        }

        if (openCnt < length) {
            cur.append("(");
            backtrack(cur, writer, openCnt + 1, closeCnt, length);
            cur.deleteCharAt(cur.length() - 1);
        }

        if (closeCnt < openCnt) {
            cur.append(")");
            backtrack(cur, writer, openCnt, closeCnt + 1, length);
            cur.deleteCharAt(cur.length() - 1);
        }

    }

}
