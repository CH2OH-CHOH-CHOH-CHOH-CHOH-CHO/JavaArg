package com.LeeCode.Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B007 {
    public static void main(String[] args) {
        new B007().threeSum(new int[]{1,2,-2,-1});
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();

        for(int i =0;i<nums.length-2;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int left =i+1;
            int right = nums.length-1;
            List<Integer> ans = new ArrayList<>();
            while (left<right){
                if (left>i+1 && nums[left]==nums[left-1]) {
                    left++;
                    continue;
                }
                if(nums[left]+nums[right]==-nums[i]){
                    ans.add(nums[i]);
                    ans.add(nums[left]);
                    ans.add(nums[right]);

                    lists.add(new ArrayList<>(ans));
                    left ++;
                    ans = new ArrayList<>();
                }
                else if(nums[left]+nums[right]<-nums[i]){
                    left++;
                }
                else right--;
            }

        }
        return lists;
    }
}
