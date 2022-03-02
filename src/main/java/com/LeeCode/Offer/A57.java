package com.LeeCode.Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A57 {
    public static void main(String[] args) {
        new A57().findContinuousSequence(9);
    }
    public int[][] findContinuousSequence(int target) {
        if(target==1) return new int[][]{{1}};
        if(target==2) return new int[][]{};
        List<int[]> lists = new ArrayList<>();
        int l = 1,r=2;
        while(l<r){
            int temp = (l+r)*(r-l+1)/2;
            if(target==temp) {
                int[] arr = new int[r-l+1];
                for(int i=l;i<=r;i++){
                    arr[i-l]=i;
                }
                lists.add(arr);
                l++;
            }
            else if(target<temp){
                l++;
            }
            else if(target>temp){
                r++;
            }
        }
        return lists.toArray(new int[lists.size()][]);
    }
}
