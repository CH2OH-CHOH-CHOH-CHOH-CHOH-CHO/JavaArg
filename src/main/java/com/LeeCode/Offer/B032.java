package com.LeeCode.Offer;


public class B032 {
    public boolean isAnagram(String s, String t) {
        if (s.equals(t)) return false;
        int len1 = s.length();
        int len2 = t.length();
        if(len1!=len2) return false;
        int[] alber = new int[26];
        for(int i =0;i<len1;i++){
            alber[s.charAt(i)-'a']++;
        }
        for(int i =0;i<len2;i++){
            alber[t.charAt(i)-'a']--;
        }
        for (int i:alber
             ) {
            if(i!=0) return false;
        }
        return true;
    }
}
