package org.example.binary;

/**
 * task: <a href="https://leetcode.com/problems/minimum-moves-to-reach-target-score/description/">Minimum Moves to Reach Target Score</a><br>
 * time complexity: {@code O(Log(target)}<br>
 * space complexity: {@code O(1)}<br>
 * difficulty: {@code medium}
 */
public class MinimumMovesToTarget {

    public int minMoves(int target, int maxDoubles) {
        if (target == 1) {
            return 0;
        }

        if (maxDoubles == 0) {
            return target - 1;
        }

        int count = 0;
        while (target != 1 && maxDoubles > 0) {
            if (target % 2 == 0) {
                target /= 2;
                maxDoubles--;
            } else {
                target -= 1;
            }
            count++;
        }

        if (target > 1) {
            return count += target - 1;
        }

        return count;
    }

}
