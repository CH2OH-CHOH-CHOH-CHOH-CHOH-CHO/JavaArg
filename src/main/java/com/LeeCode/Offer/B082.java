package com.LeeCode.Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class B082 {
    public static void main(String[] args) {
        new B082().combinationSum2(new int[]{2,5,2,1,2},5);
    }
    ArrayList<List<Integer>> list = new ArrayList<>();
    ArrayList<Integer> arr = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates,target,0);
        return list;
    }

    private void backtrack(int[] candidates, int target,int nowIndex){
        int sum = 0;
        for (int i:arr
            ) {sum+=i;
        }

        if(sum>target)  return;

        if(sum==target){
            ArrayList<Integer> copy = new ArrayList<>();
            copy.addAll(arr);
            list.add(copy);
            return;
        }

        if(sum<target){
            for(int i = nowIndex;i<candidates.length;i++){
                if(i>nowIndex && candidates[i]==candidates[i-1]) continue;
                arr.add(candidates[i]);
                backtrack(candidates, target,i+1);

                arr.remove(arr.size()-1);

            }
        }

    }

}
