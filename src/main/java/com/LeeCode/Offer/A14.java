package com.LeeCode.Offer;

public class A14 {
    public int cuttingRope(int n) {
        if(n<=3){
            return Math.max(n-1,1);
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for(int i =4;i<=n;i++){
            int ans = Integer.MIN_VALUE;
            for(int j = 1;j<=i/2;j++){
                ans = Math.max(ans,dp[j]*dp[i-j]);
            }
            dp[i] = ans;
        }

        return dp[n];
    }
}
