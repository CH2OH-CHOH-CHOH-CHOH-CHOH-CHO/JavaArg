package com.LeeCode.Offer;

import java.util.HashMap;
import java.util.HashSet;

public class B010 {
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        int len = nums.length;
        int preSum = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0,1);
        for (int i =0;i<len;i++ ){
            preSum = preSum+nums[i];
            ans = ans+hashMap.getOrDefault(preSum-k,0);
            hashMap.put(preSum,hashMap.getOrDefault(preSum,0)+1);
        }

        return ans;
    }
}
