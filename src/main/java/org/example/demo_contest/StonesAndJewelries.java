package org.example.demo_contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StonesAndJewelries {

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String jewelries = r.readLine();
        String stones = r.readLine();
        int result = 0;

        for (int i = 0; i < stones.length(); i++) {
            char ch = stones.charAt(i);
            if (jewelries.indexOf(ch) >= 0) {
                result++;
            }
        }
        System.out.println(result);
    }
}
