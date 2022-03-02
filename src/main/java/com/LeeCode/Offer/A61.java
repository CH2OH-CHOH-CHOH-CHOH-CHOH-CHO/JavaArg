package com.LeeCode.Offer;

import java.util.HashSet;

public class A61 {
    public boolean isStraight(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        HashSet<Integer> integers = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) continue;

            min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);

            if(integers.contains(nums[i])==false) {
                integers.add(nums[i]);
            }
            else return false;
        }

        if(max-min<5) return true;
        else return false;
    }
}
