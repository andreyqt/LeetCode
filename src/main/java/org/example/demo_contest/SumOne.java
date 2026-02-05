package org.example.demo_contest;

import java.util.Scanner;

public class SumOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long A = scanner.nextLong();
        long B = scanner.nextLong();
        System.out.println(A + B);
        scanner.close();
    }
}
