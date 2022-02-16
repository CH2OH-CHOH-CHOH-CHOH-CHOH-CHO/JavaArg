package com.LeeCode.Medium;

public class Medium5 {
    public static void main(String[] args) {
        System.out.println(new Medium5().longestPalindrome("a"));
    }
    public String longestPalindrome(String s) {
        int len = s.length();
        int maxStart = 0;
        int maxEnd = 0;
        boolean dp[][] = new boolean[len][len];
        for(int i = 0;i<len;i++){
            for(int j = 0;j<len-i;j++){

                //长度为1
                if(i==0) dp[j][j+i] = true;
                //长度为2
                else if(i==1) dp[j][j+i] = s.charAt(j)==s.charAt(j+i);
                //长度>=2
                else dp[j][j+i] = s.charAt(j)==s.charAt(j+i) && dp[j+1][j+i-1];

                if(dp[j][j+i]){
                    maxStart = j;
                    maxEnd = j+i;
                }
            }



        }

        return s.substring(maxStart,maxEnd+1);
    }
}
