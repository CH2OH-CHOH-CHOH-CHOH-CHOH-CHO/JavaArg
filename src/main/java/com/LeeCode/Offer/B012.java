package com.LeeCode.Offer;

public class B012 {
    public int pivotIndex(int[] nums) {
        int[] presum = new int[nums.length+1];

        int ans = 0;
        for(int i = 1;i<nums.length+1;i++){
            presum[i] = presum[i-1]+nums[i-1];
        }
        int total = presum[nums.length];
        for(int i = 0;i<nums.length+1;i++){
            if(2*presum[i]+nums[i]==total) return i;
        }

        return -1;
    }
}
