package org.example.integer;

/**
 * task: <a href="https://leetcode.com/problems/complement-of-base-10-integer/">Complement of Base 10 Integer</a><br>
 * time complexity: {@code O(Log(N))}<br>
 * space complexity: {@code O(1)}<br>
 * difficulty: {@code easy}
 */
public class ComplementBase10 {

    public int bitwiseComplement(int n) {
        if (n == 0) {
            return 1;
        }
        int res = 0;
        int i = 0;
        while (n > 0) {
            int carry = n % 2;
            if (carry == 0) {
                res = res + (1 << i);
            }
            n /= 2;
            i++;
        }
        return res;
    }

}
