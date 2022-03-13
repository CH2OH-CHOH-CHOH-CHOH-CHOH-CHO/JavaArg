package com.LeeCode.Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class B035 {
    public int findMinDifference(List<String> timePoints) {
        int[] arr = new int[timePoints.size()];
        for(int i = 0;i<timePoints.size();i++){
            arr[i]=(getminues(timePoints.get(i)));
        }
        Arrays.sort(arr);
        int ans = Integer.MAX_VALUE;
        for(int i = 0;i< arr.length-1;i++){
            ans = Math.min(ans, arr[i + 1] - arr[i]);
        }
        ans = Math.min(ans,arr[0]+1440-arr[arr.length-1]);

        return ans;
    }

    private int getminues(String s ){
        return (s.charAt(0)-'0')*10*60 +(s.charAt(1)-'0')*60+(s.charAt(3)-'0')*10+(s.charAt(4)-'0');
    }
}
