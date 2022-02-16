package com.LeeCode.Offer;

import java.util.HashMap;
import java.util.Map;

public class B011 {
    public static void main(String[] args) {
        new B011().findMaxLength(new int[]{0,1,0,0,1});
    }
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int[][] dp = new int[n][n];

        for (int len = 0; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                //1比0多为正数，0比1多为负数
                if (len ==0) {
                    dp[i][len] = nums[i]==0?-1:1;
                }
                else if (len == 1) {
                    dp[i][len] = this.isBinary(nums[i],nums[i+len]);
                    if(dp[i][len]==0) ans = len+1;
                }
                else {
                    dp[i][len] = this.isBinary(nums[i],nums[i+len])+dp[i+1][len-2];
                    if(dp[i][len]==0) ans = len+1;
                }
            }
        }

        System.out.println(ans);
        return ans;

    }
    public int findMaxLength2(int[] nums) {
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int counter = 0;
        map.put(counter, -1);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num == 1) {
                counter++;
            } else {
                counter--;
            }
            if (map.containsKey(counter)) {
                int prevIndex = map.get(counter);
                maxLength = Math.max(maxLength, i - prevIndex);
            } else {
                map.put(counter, i);
            }
        }
        return maxLength;
    }


    private int isBinary(int a,int b){
        return  Math.abs(a-1) == Math.abs(b)?0:(a==0?-2:2);
    }
}
