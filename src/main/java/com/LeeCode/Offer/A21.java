package com.LeeCode.Offer;

public class A21 {
    public int[] exchange(int[] nums) {
        int len = nums.length;
        int fPoint = 0;
        int lPoint = len-1;
        while(fPoint<lPoint){
            if(nums[fPoint]%2!=0) {
                fPoint++;
            }
            else if(nums[lPoint]%2==0) {
                lPoint--;
            }
            else {
                int temp = nums[fPoint];
                nums[fPoint] = nums[lPoint];
                nums[lPoint]=temp;
            }

        }
        return nums;
    }
}
