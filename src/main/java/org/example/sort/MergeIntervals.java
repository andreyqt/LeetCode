package org.example.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * task: <a href="https://leetcode.com/problems/merge-intervals/description/">Merge Intervals</a><br>
 * time complexity: {@code O(N*log(N))}
 * space complexity: {@code O(N)}
 * difficulty: {@code medium}
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];
        result.add(current);

        for(int i = 1; i < intervals.length; i++) {
            int[] nextInterval = intervals[i];
            int currentEnd = current[1];
            int nextStart = nextInterval[0];
            int nextEnd = nextInterval[1];
            if(nextStart <= currentEnd) {
                current[1] = Math.max(currentEnd, nextEnd);
            } else {
                current = nextInterval;
                result.add(current);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

}
