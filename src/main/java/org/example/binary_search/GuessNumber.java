package org.example.binary_search;

/**
 * task: <a href="https://leetcode.com/problems/guess-number-higher-or-lower/">Guess Game</a><br>
 * time complexity: {@code O(log(N))}<br>
 * space complexity: {@code O(1)}<br>
 * difficulty: {@code easy}
 */
public class GuessNumber {

    public int picked;

    public int guessNumber(int n) {
        int left = 1, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int res = guess(mid);

            if (res == 0) {
                return mid;
            } else if (res == 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public int guess(int n) {
        if (n > picked) {
            return -1;
        } else if (n < picked) {
            return 1;
        } else {
            return 0;
        }
    }

}
