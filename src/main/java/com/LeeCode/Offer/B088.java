package com.LeeCode.Offer;

public class B088 {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        if(len<2) return 0;
        int[] dp = new int[len+1];
        dp[0] = 0;
        dp[1] = 0;
        for(int i = 2;i<len+1;i++){
            dp[i] = Math.min(dp[i-2]+cost[i-2],dp[i-1]+cost[i-1]);
        }

        return dp[len];
    }
}
