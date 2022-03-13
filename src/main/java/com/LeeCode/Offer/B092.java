package com.LeeCode.Offer;

public class B092 {
    public int minFlipsMonoIncr(String s) {
        if (s.length()==0) return 0;
        int dp[][]=new int[s.length()][2];
        //初始化
        dp[0][0]=s.charAt(0)=='0'?0:1;
        dp[0][1]=s.charAt(0)=='1'?0:1;
        for(int i = 1;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='0'){
                dp[i][0] = dp[i-1][0];
                dp[i][1] = Math.min(dp[i-1][1],dp[i-1][0])+1;
            }
            else if(c=='1'){
                dp[i][0] = dp[i-1][0]+1;
                dp[i][1] = Math.min(dp[i-1][1],dp[i-1][0]);
            }
        }

        return Math.min(dp[s.length()-1][0],dp[s.length()-1][1]);
    }

}
