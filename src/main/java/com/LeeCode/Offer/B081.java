package com.LeeCode.Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class B081 {
    public static void main(String[] args) {
        new B081().combinationSum(new int[]{2,3,7,6},7);
    }
    ArrayList<List<Integer>> list = new ArrayList<>();
    ArrayList<Integer> arr = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates,target,0);
        return list;
    }

    private void backtrack(int[] candidates, int target,int nowIndex){
        int sum = 0;
        for (int i:arr
             ) {sum+=i;
        }



        if(sum>target) return;

        if(sum==target) {
            ArrayList<Integer> copy = new ArrayList<>(arr.size());

            Collections.copy(copy,arr);
            list.add(copy);
            return;
        }

        if(sum<target){
            for(int i = nowIndex;i<candidates.length;i++){
                arr.add(candidates[i]);
                backtrack(candidates, target,i);
                arr.remove(arr.size()-1);
            }
        }
    }
}
