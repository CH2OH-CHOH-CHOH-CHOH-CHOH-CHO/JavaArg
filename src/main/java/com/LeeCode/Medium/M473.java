package com.LeeCode.Medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class M473 {
    public List<Integer> nums;
    public int[] sums;
    public int possibleSquareSide;

    // Depth First Search function.
    public boolean dfs(int index) {
        if(index==nums.size() && sums[0]==sums[1] && sums[1]==sums[2] && sums[2]==sums[3]){
            return true;
        }

        for(int j = 0;j<4;j++){
            if(sums[j] + nums.get(index)<=possibleSquareSide){
                sums[j] += nums.get(index);
                if( dfs(index+1)) return true;
                sums[j] -=nums.get(index);
            }
        }
        return false;
    }

    public boolean makesquare(int[] nums) {
        int sum = 0;
        for (int i:nums
             ) {
            sum +=i;
        }
        this.sums = new int[4];
        possibleSquareSide = sum / 4;
        if(sum!=possibleSquareSide*4) return false;
        this.nums = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(this.nums,Collections.reverseOrder());
        return this.dfs(0);
    }

}
