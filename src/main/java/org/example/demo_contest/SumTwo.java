package org.example.demo_contest;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SumTwo {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new File("input.txt"));
        long A = scanner.nextLong();
        long B = scanner.nextLong();
        scanner.close();

        PrintWriter writer = new PrintWriter(new File("output.txt"));
        writer.println(A + B);
        writer.close();
    }
}
