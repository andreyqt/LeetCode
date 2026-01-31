package org.example.prime_numbers;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * task: from interview<br>
 * time complexity: {@code O(N*log(N)*log(log(N)))}<br>
 * space complexity: {@code O(N)}<br>
 * difficulty: {@code medium}
 */
public class PrimeNumberService {

    public Set<Integer> findPrimesUpTo(int N) {
        if (N < 2) {
            return Set.of();
        }

        Set<Integer> numbers = IntStream.rangeClosed(2, N)
                .boxed()
                .collect(Collectors.toSet());

        for (int i = 2; i <= N; i++) {
            if (numbers.contains(i)) {
                for (int p = i * i; p <= N; p = p + i) {
                    numbers.remove(p);
                }
            }
        }
        return numbers;
    }

}
