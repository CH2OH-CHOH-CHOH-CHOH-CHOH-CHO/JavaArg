package com.LeeCode.Medium;

import java.util.ArrayDeque;

public class Medium151 {
    public static void main(String[] args) {
        String s = "  hello world  ";
        System.out.println(new Medium151().reverseWords(s));
    }
    public String reverseWords(String s) {
        int len = s.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = len-1,j=len-1; i >=0; ) {
            if(s.charAt(i)==32 && s.charAt(j)==32){
                j=--i;
            }
            else if(s.charAt(i)==32 || i==0){
                if(i!=0)  stringBuilder.append(s.substring(i+1,j+1));
                else {
                    stringBuilder.append(s.substring(i,j+1));
                    break;
                }
                j=i;
            }
            else i--;
        }
        return stringBuilder.toString();
    }
}
