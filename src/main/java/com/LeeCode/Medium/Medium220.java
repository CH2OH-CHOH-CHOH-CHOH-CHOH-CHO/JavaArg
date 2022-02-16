package com.LeeCode.Medium;

import java.util.TreeSet;
/*给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。

        如果存在则返回 true，不存在返回 false。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/contains-duplicate-iii
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class Medium220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> integers = new TreeSet();
        for(int i =0;i<nums.length;i++){
            Long ceiling = integers.ceiling((long)nums[i] - (long)t);
            if(ceiling!=null && ceiling<=(long)nums[i]+t) return true;
            else{
                integers.add((long)nums[i]);
                if(i>=k){
                    integers.remove((long)nums[i-k]);
                }
            }
        }
        return false;
    }
}
