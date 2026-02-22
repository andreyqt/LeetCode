package org.example.integer;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * task: from interview<br>
 * time complexity: {@code O(N*log(log(N)))}<br>
 * space complexity: {@code O(N)}<br>
 * difficulty: {@code medium}
 */
public class PrimeNumberService {

    public Set<Integer> findPrimesUpTo(int N) {
        if (N < 2) {
            return Collections.emptySet();
        }

        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        Set<Integer> primes = new HashSet<>();
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }

}
