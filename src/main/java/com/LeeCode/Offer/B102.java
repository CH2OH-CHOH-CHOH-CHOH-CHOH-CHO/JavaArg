package com.LeeCode.Offer;

public class B102 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i:nums
             ) {
            sum += i;
        }
        int neg = sum-target;
        if(neg<0||neg%2!=0) return 0;
        int[] dp = new int[neg+1];
        dp[0] =1;
        neg = neg/2;
        for (int i = 1; i < nums.length+1; i++) {
            for (int j = 0; j < neg + 1; j++) {
                if(j>=nums[i-1])  dp[j] = dp[j] +dp[j-nums[i-1]];
            }
        }
        return dp[neg];
    }
}
