package org.example.conditioner;

import java.util.Scanner;

/*
 * task: <a href="https://contest.yandex.ru/contest/27393/problems/A/">conditioner</a><br>
 */
public class Conditioner {

    //first arg has the format of "t1 t2", where t1 is the current t, and t2 is desired t
    public static int estimateTemperature(String temperatures, String mode) {
        String[] temps = temperatures.split("\\s+");
        int t1 = Integer.parseInt(temps[0]);
        int t2 = Integer.parseInt(temps[1]);
        verifyArgs(t1, t2);
        return switch (mode) {
            case "freeze" -> Math.min(t1, t2);
            case "heat" -> Math.max(t1, t2);
            case "auto" -> t2;
            case "fan" -> t1;
            default -> throw new IllegalStateException("Unknown mode: " + mode);
        };
    }

    public static void verifyArgs(int tRoom, int tCond) {
        if (tRoom > 50 || tCond > 50 || tRoom < -50 || tCond < -50) {
            throw new IllegalArgumentException("invalid arg(s)");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String temperatures = scanner.nextLine();
        String mode = scanner.nextLine();

        int result = estimateTemperature(temperatures, mode);
        System.out.println(result);
        scanner.close();
    }

}
