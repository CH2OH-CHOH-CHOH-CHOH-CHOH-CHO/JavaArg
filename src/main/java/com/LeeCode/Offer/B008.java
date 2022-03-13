package com.LeeCode.Offer;

public class B008 {
    public static void main(String[] args) {
        new B008().minSubArrayLen(7, new int[]{2,3,1,2,4,3});
    }
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }


        int left= 0;
        int right = 0;
        int len = Integer.MAX_VALUE;
        int sum = nums[0];

        while(right<n){
            sum += nums[right];
            while (sum >= target) {
                len = Math.min(len, right-left + 1);
                sum -= nums[left];
                left++;
            }
            right ++;
        }

        return len==Integer.MAX_VALUE ? 0 : len;
    }
}
