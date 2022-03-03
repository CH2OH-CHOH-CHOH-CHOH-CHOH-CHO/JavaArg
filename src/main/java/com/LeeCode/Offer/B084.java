package com.LeeCode.Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class B084 {
    public static void main(String[] args) {
        new B084().permuteUnique(new int[]{3, 3, 0, 3});
    }

    List<List<Integer>> lists = new ArrayList<>();
    List<Integer> arr = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
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

        HashSet<Integer> hashSet = new HashSet<>();
        for(int i = 0;i<nums.length;i++){
            if(isUse[i]==true || hashSet.contains(nums[i])) continue;
            else {
                isUse[i] =true;
                arr.add(nums[i] );
                hashSet.add(nums[i]);

                backtrack(nums,isUse);

                isUse[i] =false;
                arr.remove(arr.size()-1);

            }
        }
    }
}
