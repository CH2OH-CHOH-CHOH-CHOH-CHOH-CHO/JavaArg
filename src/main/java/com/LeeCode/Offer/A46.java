package com.LeeCode.Offer;

public class A46 {
    public static void main(String[] args) {
         new A46().translateNum(18822);
    }
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int n = s.length();
        if(n<1) return 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1;i<n;i++){
            int a = Integer.valueOf(s.substring(i-1,i+1));
            if(i==1) dp[i] = dp[i-1] + ((a>=10 && a <=25)? 1:0);
            else dp[i] = dp[i-1] + ((a>=10 && a <=25)? dp[i-2]:0);
        }
        return dp[n-1];
    }
}
