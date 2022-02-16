package com.LeeCode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
给你一个整数数组 nums，和一个整数 k 。

        对于每个下标 i（0 <= i < nums.length），将 nums[i] 变成 nums[i] + k 或 nums[i] - k 。

        nums 的 分数 是 nums 中最大元素和最小元素的差值。

        在更改每个下标对应的值之后，返回 nums 的最小 分数 。

         

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/smallest-range-ii
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class Medium910 {
    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        int min ;
        int max ;
        int len = nums.length;
        int diff=nums[len-1]-nums[0];
        for(int i = 0;i<len-1;i++){
            max= Math.max(nums[i]+k,nums[len-1]-k);
            min = Math.min(nums[0]+k,nums[i+1]-k);
            diff = Math.min(max - min, diff);
        }
        return diff;
    }
}
