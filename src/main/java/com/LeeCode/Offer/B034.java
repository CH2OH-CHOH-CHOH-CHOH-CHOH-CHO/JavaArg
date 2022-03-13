package com.LeeCode.Offer;

import java.util.HashMap;

public class B034 {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for(int i =0;i<order.length();i++){
            hashMap.put(order.charAt(i),i);
        }

        for(int i = 0;i<words.length-1;i++){
            String s1 = words[i];
            String s2 = words[i+1];
            for(int j = 0;j<Math.max(s1.length(),s2.length());j++){
                int idx1 = j>=s1.length()? -1:hashMap.get(s1.charAt(j));
                int idx2 = j>=s2.length()? -1:hashMap.get(s2.charAt(j));
                if(idx1<idx2) break;
                else if(idx1>idx2) return false;
            }
        }
        return true;
    }
}
