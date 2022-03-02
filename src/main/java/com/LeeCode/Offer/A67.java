package com.LeeCode.Offer;

public class A67 {
    public static void main(String[] args) {
        new A67().strToInt(" -42");
    }
    public int strToInt(String str) {
        if(str==null || str.length()==0) return 0;

        int i =0;
        int isNegative=1;
        int ans =0;

        //清除空格
        while(i<str.length() && str.charAt(i)==' ') i++;

        //排除错误情况
        if(i==str.length()) return 0;
        else if(str.charAt(i)=='-'||str.charAt(i)=='+') {
            isNegative = str.charAt(i)=='-'? -1:1;
            i++;
        }
        else if(str.charAt(i) < '0' || str.charAt(i) > '9') return 0;


        for(int j = i;j<str.length() ;j++){
            if(str.charAt(j) < '0' || str.charAt(j) > '9') break;
            int temp=Integer.parseInt(""+ str.charAt(j));
            if(ans>Integer.MAX_VALUE/10) return isNegative==-1? Integer.MIN_VALUE:Integer.MAX_VALUE;
            else if(ans==Integer.MAX_VALUE/10 && temp>7) return isNegative==-1? Integer.MIN_VALUE:Integer.MAX_VALUE;
            ans =temp+ans*10;

        }
        return ans*isNegative;
    }
}
