package com.LeeCode.Medium;

public class Medium375 {
    public static void main(String[] args) {
        new Medium375().getMoneyAmount(10);
    }
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+2][n+2];
        for(int len =2;len<=n;len++){
            for(int i =1;i+len-1<=n;i++){
                int min = Integer.MAX_VALUE;
                int j = i+len-1;
                for(int k =i;k<=j;k++){
                    int cost = k+Math.max(dp[i][k-1],dp[k+1][j]);
                    min = Math.min(min, cost);
                }
                dp[i][j]= min;
            }
        }

        return dp[1][n];
    }
}
