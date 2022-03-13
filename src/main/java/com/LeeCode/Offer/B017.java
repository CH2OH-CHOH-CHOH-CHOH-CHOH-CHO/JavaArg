package com.LeeCode.Offer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class B017 {
    public static void main(String[] args) {
        new B017().minWindow("ADOBECODEBANC","ABC");
    }
    public String minWindow(String s, String t) {
        int len = s.length();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        HashMap<Character, Integer> cnt = new HashMap<>();

        for(int i = 0;i<t.length();i++){
            hashMap.put(t.charAt(i),hashMap.getOrDefault(t.charAt(i),0)+1);
        }
        int ansStart = -1;
        int ansLen = Integer.MAX_VALUE;
        int left = 0;
        int right= -1;
        while(right <len){
            right++;
            if(right <len && hashMap.containsKey(s.charAt(right))){
                cnt.put(s.charAt(right),cnt.getOrDefault(s.charAt(right),0)+1);
            }
            while(check(hashMap,cnt) && left<=right){
                if(right-left+1<ansLen){
                    ansStart = left;
                    ansLen = right-left+1;
                }

                if(hashMap.containsKey(s.charAt(left))){
                    cnt.put(s.charAt(left),cnt.getOrDefault(s.charAt(left),0)-1);
                }
                left++;
            }

        }

        return ansStart == -1 ? "" : s.substring(ansStart, ansStart + ansLen);
    }

    public boolean check(HashMap<Character, Integer> ori,HashMap<Character, Integer> cnt) {
        for (Map.Entry<Character, Integer> characterIntegerEntry : ori.entrySet()) {
            Map.Entry entry = (Map.Entry) characterIntegerEntry;
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }

}
