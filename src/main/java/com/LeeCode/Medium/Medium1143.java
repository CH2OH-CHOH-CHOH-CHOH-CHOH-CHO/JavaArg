package com.LeeCode.Medium;

public class Medium1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int mark = 0;
        int max = 0;
        for(int i=0;i<len1;i++){
            for(int j = mark;j<len2;j++){
                if(text2.charAt(j)==text1.charAt(i))  {
                    max++;
                    mark = j+1;
                    break;
                }
            }
        }
        return 0;
    }
}
