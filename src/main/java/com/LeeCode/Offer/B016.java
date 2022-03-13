package com.LeeCode.Offer;

import java.util.HashSet;

public class B016 {
    public static void main(String[] args) {
         new B016().lengthOfLongestSubstring("abcabcbb");
    }
    public int lengthOfLongestSubstring(String s) {

        int len = s.length();
        if(len==0) return 0;
        if(len==1) return 1;
        HashSet<Character> hashSet = new HashSet<>();
        int right = 1;
        int left = 0;
        int ans = 0;
        hashSet.add(s.charAt(0));
        while(right <len){
            while (hashSet.contains(s.charAt(right))){
                hashSet.remove(s.charAt(left));
                left++;
            }
            hashSet.add(s.charAt(right));
            right++;
            ans = Math.max(ans,right-left);
        }
        ans = Math.max(ans,right-left);
        return ans;
    }
}
