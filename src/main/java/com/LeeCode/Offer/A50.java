package com.LeeCode.Offer;

import java.util.HashMap;
import java.util.HashSet;

public class A50 {
    public char firstUniqChar(String s) {
        if (s==null||s.length()==0) return ' ';
        /*frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);*/
        //Δ
        int[] alber = new int[26];
        for(int i = 0;i<s.length();i++){
            alber[s.charAt(i)-'a']++;
        }

        for(int i = 0;i<s.length();i++){
            if(alber[s.charAt(i)-'a']==1) return s.charAt(i);
        }
        return ' ';
    }
}
