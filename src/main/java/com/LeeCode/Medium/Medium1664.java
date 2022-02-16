package com.LeeCode.Medium;
/*给你一个整数数组 nums 。你需要选择 恰好 一个下标（下标从 0 开始）并删除对应的元素。请注意剩下元素的下标可能会因为删除操作而发生改变。

        比方说，如果 nums = [6,1,7,4,1] ，那么：

        选择删除下标 1 ，剩下的数组为 nums = [6,7,4,1] 。
        选择删除下标 2 ，剩下的数组为 nums = [6,1,4,1] 。
        选择删除下标 4 ，剩下的数组为 nums = [6,1,7,4] 。
        如果一个数组满足奇数下标元素的和与偶数下标元素的和相等，该数组就是一个 平衡数组 。

        请你返回删除操作后，剩下的数组 nums 是 平衡数组 的 方案数 。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/ways-to-make-a-fair-array
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class Medium1664 {
    public int waysToMakeFair(int[] nums) {
         int len = nums.length;
         int[] dp = new int[len+1];
         dp[0] = 0;
         for(int i=1;i<len+1;i++){
             dp[i]=dp[i-1]+ ((i & 0x01)==0? nums[i-1]: -nums[i-1]);
         }
        int rev = 0;
        for(int i=1;i<len+1;i++){
            if(dp[i-1]==dp[len]-dp[i]) rev++;
        }

        return  rev;
    }
}
