package com.LeeCode.Offer;

public class B020 {
    public int countSubstrings(String s) {
        int n = s.length();
        int trueNumber = 0;
        boolean[][] dp = new boolean[n][n];
        for(int len = 0;len<n;len++){
            for(int i = 0;i<n-len;i++){
                if(len==0) {
                    dp[i][0]=true;
                    trueNumber++;
                }
                else if(len==1) {
                    if(dp[i][1] = s.charAt(i) == s.charAt(i + 1)) trueNumber++;
                }
                else {
                    if(dp[i][len] = s.charAt(i)==s.charAt(i+len) && dp[i+1][len-2]) trueNumber++;
                }
            }
        }
    return trueNumber;
    }
}
