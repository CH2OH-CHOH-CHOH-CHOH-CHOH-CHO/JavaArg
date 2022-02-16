package com.LeeCode.Medium;

public class Medium96 {
    public static void main(String[] args) {
        System.out.println(new Medium96().numTrees(19));
    }
    public int numTrees(int n) {
        int dp[] = new int[20];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        for(int i =3;i<=n;i++){
            for(int j =0;j<i;j++){
                dp[i]=dp[i]+dp[j]*dp[i-1-j];
            }
        }

        return dp[n];
    }



}
