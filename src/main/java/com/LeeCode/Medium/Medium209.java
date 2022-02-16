package com.LeeCode.Medium;
/*给定一个含有 n 个正整数的数组和一个正整数 target 。

        找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class Medium209 {
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,1,2,4,3};
        new Medium209().minSubArrayLen(7,arr);
    }
    public int minSubArrayLen(int target, int[] nums) {
        int len =nums.length;
        int start =0;
        int end = 0;
        int sum =0;
        int ans = nums.length+1;
        sum=nums[0];
        for(int i =0;i<len;){
            if(sum>=target ) {
                end = i;
                ans = Math.min(end -start +1,ans);
                sum -= nums[start++];
            }
            else if(i<len-1){
                i++;
                sum += nums[i];
            }
            else break;
        }
        if(ans>nums.length) return  0 ;
        else return ans;
    }

}
