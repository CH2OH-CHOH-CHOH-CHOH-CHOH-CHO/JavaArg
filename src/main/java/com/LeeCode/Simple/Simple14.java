package com.LeeCode.Simple;

public class Simple14 {
    public static void main(String[] args) {
        System.out.println(new Simple14().longestCommonPrefix(new String[]{"a"}));
    }
    public String longestCommonPrefix(String[] strs) {
        if(strs==null ||strs.length==0) return "";
        int len=strs.length;
        int min = strs[0].length();
        for(int i =1;i<len;++i){
            min = Math.min(min,strs[i].length());
        }
        int i;
        for(i =0;i<min;++i){
            boolean ans=true;
            for(int j=0;j<len-1;++j){
                ans=ans && (strs[j].charAt(i)==strs[j+1].charAt(i));
                if(!ans) break;
            }
            if(!ans) break;
        }
        if(i==0) return "";
        return strs[0].substring(0,i);
    }
}
