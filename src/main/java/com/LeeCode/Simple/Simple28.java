package com.LeeCode.Simple;

public class Simple28 {
    public static void main(String[] args) {
        System.out.println(new Simple28().strStr("aaa", "aaaa"));
    }
    public int strStr(String haystack, String needle) {
        if(needle==null || needle.length()==0) return 0;
        if(haystack==null || haystack.length()==0) return -1;



        for(int i=0;i<haystack.length()-haystack.length();++i){
            int j=0;
//            for(j =0;j<needle.length();++j){
//                if( haystack.charAt(i+j)!=needle.charAt(j)){
//                    break;
//                }
//
//            }
            while(j<needle.length()){
                if( haystack.charAt(i+j)!=needle.charAt(j)){
                    break;
                }
                j++;
            }
            if(j==needle.length()){
                return i;
            }
        }
        return -1;
    }
}
