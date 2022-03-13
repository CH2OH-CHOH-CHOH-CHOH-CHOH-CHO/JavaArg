package com.LeeCode.Offer;

public class B090 {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);
        if(nums.length==3) return Math.max(nums[0],Math.max(nums[1],nums[2]));
        int a = rob1(nums);
        int b = rob2(nums);
        return Math.max(a,b);
    }

    private int rob1(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i =2;i<len-1;i++){
            dp[i] = Math.max(nums[i]+dp[i-2],dp[i-1]);
        }

        return dp[len-2];
    }

    private int rob2(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[1] = nums[1];
        dp[2] = Math.max(nums[1],nums[2]);
        for(int i =3;i<len;i++){
            dp[i] = Math.max(nums[i]+dp[i-2],dp[i-1]);
        }

        return dp[len - 1];
    }
}
