package com.LeeCode.Offer;

public class B009 {
    public static void main(String[] args) {
        new B009().numSubarrayProductLessThanK(new int[]{10, 5, 2, 6},100);
    }
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k==0) return 0;
        int len = nums.length;
        int left = 0;
        int right =0;
        int mul = 1;
        int number = 0;
        while(right<len){
            if(mul*nums[right]<k){
                mul *= nums[right];
                number += (right-left+1);
                right++;
            }
            else if(left==right){
                mul=1;
                right ++;
                left=right;
            }
            else {
                mul =mul/nums[left];
                left++;
            }
        }

        return number;
    }
}
