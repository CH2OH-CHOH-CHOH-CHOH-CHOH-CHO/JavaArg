package com.LeeCode.Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class B079 {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> lists = new LinkedList<>();
        lists.add(new LinkedList<>());
        for(int i = 0;i<n;i++){
            for(int j = i;j<n;j++){
                LinkedList<Integer> linkedList = new LinkedList<>();
                linkedList.add(nums[i]);
                for(int k = 0;k<i-j;k++){
                    linkedList.add(nums[j]);
                }
                lists.add(linkedList);
            }
        }
        return lists;
    }
}
