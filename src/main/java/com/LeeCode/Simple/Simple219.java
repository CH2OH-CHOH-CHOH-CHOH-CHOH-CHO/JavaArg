package com.LeeCode.Simple;

import java.util.HashSet;
import java.util.Set;

public class Simple219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i<nums.length;i++){

            if(i>k) {
                set.remove(nums[i - k]);
            }
            if(set.contains(nums[i])) return true;
            else set.add(nums[i]);
        }

        return false;
    }
}
