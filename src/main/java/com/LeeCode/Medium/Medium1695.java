package com.LeeCode.Medium;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Medium1695 {
    public static void main(String[] args) {
        int[] arr = new int[]{
                4,2,4,5,6};
        new Medium1695().maximumUniqueSubarray(arr);
    }
    public int maximumUniqueSubarray(int[] nums) {
        int max=0;
        int len = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int i =0,j=0;i<len && j<=i; i++){
            if(set.contains(nums[i]) ){

                //计算最大值
                int temp =0;
                for(int m=j;m<i;m++){
                    temp = temp + nums[m];
                }
                max = Math.max(max,temp);

                //移除相同数以及之前的数
                while(set.contains(nums[i])) {
                    set.remove(nums[j]);
                    j++;
                }
                set.add(nums[i]);

            }
            else if(i==len-1){
                int temp =0;
                for(int m=j;m<=i;m++){
                    temp = temp + nums[m];
                }
                max = Math.max(max,temp);
            }
            else {
                set.add(nums[i]);
            }
        }

        return max;
    }

    public int maximumUniqueSubarray2(int[] nums) {
        // 存放前缀和
        int[] array = new int[nums.length + 1];
        // 存放数组中的最大值，用来确定标记数组的长度
        int maxlength = 0;
        // 首先对数组进行预处理并求出最大值
        for (int i = 0; i < nums.length; i++) {
            array[i + 1] = array[i] + nums[i];
            maxlength = Math.max(maxlength, nums[i]);
        }
        int max = 0;
        // 创建标记数组
        boolean[] sign = new boolean[maxlength + 1];
        // 记录起始下标
        int start = 0;
        // 记录结束下标
        int end = 0;
        while (end < nums.length) {
            // 窗口扩大向后移动
            for (; end < nums.length; end++) {
                // 如果该数已被访问过则结束循环
                if (sign[nums[end]]) {
                    break;
                }
                // 对于访问过的数做标记
                sign[nums[end]] = true;
            }
            // 计算窗口的和
            int sum = array[end] - array[start];
            // 求出最大的和
            if (max < sum) {
                max = sum;
            }
            if (end < nums.length) {
                // 窗口缩小，向右移动
                while (start < end && nums[end] != nums[start]) {
                    // 回溯标记过的下标
                    sign[nums[start]] = false;
                    start++;
                }
                sign[nums[start]] = false;
                start++;
            }
        }
        return max;
    }

}
