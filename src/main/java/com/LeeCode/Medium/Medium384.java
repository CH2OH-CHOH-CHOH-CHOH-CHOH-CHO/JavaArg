package com.LeeCode.Medium;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

/*给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。打乱后，数组的所有排列应该是 等可能 的。

        实现 Solution class:

        Solution(int[] nums) 使用整数数组 nums 初始化对象
        int[] reset() 重设数组到它的初始状态并返回
        int[] shuffle() 返回数组随机打乱后的结果
         

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/shuffle-an-array
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class Medium384 {
    private int[] arr ;

    public Medium384(int[] nums) {
        this.arr = nums;
    }

    public int[] reset() {
        return arr;
    }

    public int[] shuffle() {
        Random random = new Random();
        int[] nums = arr;
        for (int i = 0; i < nums.length; ++i) {
            int j = i + random.nextInt(nums.length - i);
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        return nums;
    }
}
