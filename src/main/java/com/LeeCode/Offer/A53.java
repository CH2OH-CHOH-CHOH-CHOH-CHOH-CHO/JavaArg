package com.LeeCode.Offer;

public class A53 {
    public static void main(String[] args) {
        new A53().search(new int[]{5,7,7,8,8,10},8);
    }
    public int search(int[] nums, int target) {
        if(nums.length==0 || nums==null) return 0;
        int l =0,r=nums.length-1;
        int leftIdx = 0;
        int rightIdx = 0;
        while(l<=r){
            int mid = (r+l)/2;
            if(nums[mid]>=target) {
                r=mid-1;
                leftIdx=mid;
            }
            else{
                l=mid+1;
            }
        }

        l =0;
        r=nums.length-1;
        while(l<=r){
            int mid = (r+l)/2;
            if(nums[mid]>target) {
                r=mid-1;
                rightIdx=mid;
            }
            else{
                l=mid+1;
            }
        }
        if(nums[leftIdx]!=target) return 0;
        return rightIdx-leftIdx+1;
    }
}
