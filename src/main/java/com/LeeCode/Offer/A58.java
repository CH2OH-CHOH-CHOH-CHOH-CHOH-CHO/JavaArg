package com.LeeCode.Offer;

public class A58 {
    public String reverseWords(String s) {
        s= s.trim();
        int i = s.length()-1, j =i;
        StringBuilder stringBuilder = new StringBuilder();
        while(i>=0){
            while(i >= 0 && s.charAt(i)!=' ') i--;
            stringBuilder.append(s.substring(i+1,j+1));
            while (i >= 0 &&s.charAt(i)==' ') i--;
            j=i;
            if(i>=0) stringBuilder.append(" ");
        }

        return stringBuilder.toString();
    }
}
