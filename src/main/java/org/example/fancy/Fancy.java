package org.example.fancy;

import java.util.ArrayList;
import java.util.List;

/**
 * task: <a href="https://leetcode.com/problems/fancy-sequence/description/">Fancy Sequence</a><br>
 * difficulty: {@code hard}
 */
public class Fancy {

    private static final int MOD = 1_000_000_007;
    private List<Long> values;
    private long add;
    private long mul;

    public Fancy() {
        values = new ArrayList<>();
        add = 0;
        mul = 1;
    }

    public void append(int x) {
        long base = (x - add + MOD) % MOD;
        base = (base * ModInt.modInverse(mul)) % MOD;
        values.add(base);
    }

    public void addAll(int inc) {
        add = (add + inc) % MOD;
    }

    public void mulAll(int inc) {
        mul = (mul * inc) % MOD;
        add = (add * inc) % MOD;
    }

    public int getIndex(int idx) {
        if (idx >= values.size()) {
            return -1;
        }
        long result = (values.get(idx) * mul + add) % MOD;
        return (int) result;
    }

    private static class ModInt {
        private long val;

        public long getVal() {
            return val;
        }

        public ModInt(long val) {
            this.val = (val % MOD + MOD) % MOD;
        }

        public ModInt add(long x) {
            return new ModInt((this.val + x) & MOD);
        }

        public ModInt multiply(long x) {
            return new ModInt((this.val * x) % MOD);
        }

        public static long modPow(long base, long exp) {
            long result = 1;
            base %= MOD;
            while (exp > 0) {
                if ((exp & 1) == 1) {
                    result = (result * base) % MOD;
                }
                base = (base * base) % MOD;
                exp >>= 1;
            }
            return result;
        }

        public static long modInverse(long x) {
            return modPow(x, MOD - 2);
        }

    }

}
