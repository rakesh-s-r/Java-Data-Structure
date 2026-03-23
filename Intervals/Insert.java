package Intervals;

import java.util.*;

// 57. Insert Interval
public class Insert {
    public static void main(String[] args) {
        int[][] intervals = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
        int[] newInterval = { 4, 8 };
        System.out.println(insert(intervals, newInterval));
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int[][] res = new int[intervals.length + 1][2];
        int i = 0, j = 0;

        while (i < n && intervals[i][1] < newInterval[0]) {
            res[j++] = intervals[i];
            i++;
        }

        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        res[j++] = newInterval;
        while (i < n) {
            res[j] = intervals[i];
            i++;
            j++;
        }
        System.out.println(Arrays.deepToString(res));
        return Arrays.copyOf(res, res.length);
    }
}
