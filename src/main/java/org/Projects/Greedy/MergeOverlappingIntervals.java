package org.Projects.Greedy;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingIntervals {

    private class Pair{
        int st;
        int end;

        Pair(int st, int end) {
            this.st = st;
            this.end = end;
        }
    }

    public int[][] merge(int[][] intervals) {

        //sorting on the basis of increasing start times and
        // decreasing end times, in case of a tie breaker on start times
        Arrays.sort(intervals, (int[] a, int[] b) -> (a[0] == b[0]) ? b[1] - a[1] : a[0] - b[0]);

        int st = intervals[0][0];
        int end = intervals[0][1];
        List<Pair> merged_intervals = new ArrayList<>();

        for(int[] interval : intervals) {
            if(interval[0] <= end) { // we have to merge the intervals
                end = Math.max(end, interval[1]);
            } else { // store the interval till now, and start the new interval
                merged_intervals.add(new Pair(st, end));
                st = interval[0];
                end = interval[1];
            }
        }

        merged_intervals.add(new Pair(st, end));

        int[][] ans = new int[merged_intervals.size()][2];
        int ptr = 0;

        for(Pair interval : merged_intervals) {
            ans[ptr][0] = interval.st;
            ans[ptr][1] = interval.end;
            ptr++;
        }

        return ans;
    }
}
