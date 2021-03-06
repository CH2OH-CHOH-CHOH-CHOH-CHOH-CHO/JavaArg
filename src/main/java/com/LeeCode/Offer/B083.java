package com.LeeCode.Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B083 {

    List<List<Integer>> lists = new ArrayList<>();
    List<Integer> arr = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        boolean[] isUse = new boolean[nums.length];
        backtrack(nums, isUse);
        return lists;
    }

    private void backtrack(int[] nums,boolean[] isUse){
        if(arr.size()==nums.length) {
            List<Integer> copy = new ArrayList<>();
            copy.addAll(arr);
            lists.add(copy);
            return;
        }

        int record = -11;
        for(int i = 0;i<nums.length;i++){
            if(isUse[i]==true || (record==nums[i])) continue;
            else {

                isUse[i] =true;
                arr.add(nums[i] );

                backtrack(nums,isUse);
                isUse[i] =false;
                arr.remove(arr.size()-1);
                record = nums[i];
            }
        }
    }
}
