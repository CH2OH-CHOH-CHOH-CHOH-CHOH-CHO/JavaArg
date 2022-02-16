package com.LeeCode.Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class B074 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }

        //Δ
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        //Δ
        List<int[]> merged = new ArrayList<int[]>();
        for(int i = 0;i< intervals.length;i++){
            int L = intervals[i][0], R = intervals[i][1];
            //Δ
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }


        }
        //Δ
        return merged.toArray(new int[merged.size()][]);
    }
}
