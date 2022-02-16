package com.LeeCode.Simple;

import java.util.Arrays;

/*给你一个整数数组 nums，请你给数组中的每个元素 nums[i] 都加上一个任意数字 x （-k <= x <= k），从而得到一个新数组 result 。

        返回数组 result 的最大值和最小值之间可能存在的最小差值。

         

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/smallest-range-i
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class Simple908 {
    public int smallestRangeI(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        int max = nums[len - 1];
        int min = nums[0];
        if(max -min<=k*2) return 0;
        else return max-min -k*2;
    }
}
