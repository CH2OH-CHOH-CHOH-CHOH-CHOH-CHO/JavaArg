package com.LeeCode.Offer;

import java.util.HashSet;

public class B119 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        int n =nums.length;

        for(int i=0;i<n;i++){
            hashSet.add(nums[i]);

        }

        int ans = 0;
        for(int i=0;i<n;i++){
           if(hashSet.contains(nums[i]-1)){
               continue;
           }
           else {
               int num = nums[i];
               int x = 0;
               while(hashSet.contains(num++)){
                   x++;
               }
               ans = Math.max(ans, x);
           }

        }
        return ans;
    }
}
