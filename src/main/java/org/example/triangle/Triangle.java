package org.example.triangle;

import java.util.Scanner;

/*
 * task: <a href="https://contest.yandex.ru/contest/27393/problems/B/">triangle</a><br>
 */
public class Triangle {

    //input numbers are natural
    public static String isTriangle(int a, int b, int c) {
        if (a >= b + c) {
            return "NO";
        }
        if (b >= c + a) {
            return "NO";
        }
        if (c >= a + b) {
            return "NO";
        }
        return "YES";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        String isTriangle = isTriangle(a, b, c);
        System.out.println(isTriangle);
        scanner.close();
    }

}
