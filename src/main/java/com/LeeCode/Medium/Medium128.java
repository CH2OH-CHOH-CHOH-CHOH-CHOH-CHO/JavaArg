package com.LeeCode.Medium;

import java.util.HashSet;
import java.util.Set;

public class Medium128 {
    public int longestConsecutive(int[] nums) {
        int len =nums.length;
        int maxlen = 0;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<len;i++){
            set.add(nums[i]);
        }
        for(int i =0;i<len;i++){
            if(set.contains(nums[i]-1)) continue;
            else {
                int temp = 1;
                while (set.contains(nums[i]+temp)) temp++;
                maxlen = Math.max(maxlen,temp);
            }
        }
        return maxlen;
    }
}
