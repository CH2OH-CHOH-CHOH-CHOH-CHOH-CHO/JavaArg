package com.LeeCode.Medium;

public class Medium55 {
    public boolean canJump(int[] nums) {

        int i=1;
        int tryTimes = 0;
        while(nums.length>i+tryTimes){
            if(nums[nums.length-1-i-tryTimes]>=1+tryTimes){
                i=i+1+tryTimes;
                tryTimes = 0;
            }
            else tryTimes++;

        }

        if(i>=nums.length) return true;
        else return false;
    }
}
