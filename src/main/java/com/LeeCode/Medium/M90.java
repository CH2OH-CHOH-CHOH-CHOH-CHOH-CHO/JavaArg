package com.LeeCode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M90 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> integers = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums,0);

        return ans;

    }

    private void dfs(int[] nums,int index){
        List<Integer> copy = new ArrayList<>(integers);
        ans.add(copy);

        for(int i = index;i<nums.length;i++){
            if(i>index && nums[i]==nums[i-1]) continue;

            integers.add(nums[i]);

            dfs(nums,i+1);

            integers.remove(integers.size()-1);
        }
    }
}
