package org.example.binary;

/**
 * task: <a href="https://leetcode.com/problems/powx-n/">Pow(x, n)</a><br>
 * time complexity: {@code O(Log(N))}<br>
 * space complexity: {@code O(1)}<br>
 * difficulty: {@code medium}
 */
public class BinaryPow {

    public double myPow(double x, int n) {
        if (x == 1) return 1;
        if (n == 0) return 1;

        long N = n;
        if (n < 0) {
            x = 1 / x;
            N = - N;
        }

        double res = 1.0;
        double curr = x;
        while (N > 0) {

            if (N % 2 == 1) {
                res = res * curr;
            }
            curr = curr * curr;
            N = N / 2;

        }
        return res;
    }

}
