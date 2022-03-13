package com.LeeCode.Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B015 {
    public List<Integer> findAnagrams(String s1, String s2) {
        int n = s1.length(),m = s2.length();

        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        List<Integer> ans = new ArrayList<>();
        if(n<m) return  ans;
        for(int i = 0;i<m;i++){
            cnt1[s1.charAt(i)-'a'] ++;
            cnt2[s2.charAt(i)-'a'] ++;
        }

        if(Arrays.equals(cnt1,cnt2)) ans.add(0);

        for(int i = m;i<n;i++){
            cnt2[s2.charAt(i)-'a'] ++;
            cnt2[s2.charAt(i-m)-'a'] --;
            if(Arrays.equals(cnt1,cnt2)) ans.add(i);
        }

        return ans;
    }
}
