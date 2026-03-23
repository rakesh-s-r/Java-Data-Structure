package Intervals;

import java.util.*;

public class Merge {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(merge(new int[][] { { 1, 4 }, { 0, 4 } })));
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);
        System.out.println(Arrays.deepToString(intervals));
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        int[] newInterval = res.get(0);
        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[1]) {
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            } else {
                newInterval = interval;
                res.add(newInterval);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
