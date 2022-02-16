package com.LeeCode.Medium;

import java.util.Arrays;

/*给你一个正整数数组 arr 。请你对 arr 执行一些操作（也可以不进行任何操作），使得数组满足以下条件：

        arr 中 第一个 元素必须为 1 。
        任意相邻两个元素的差的绝对值 小于等于 1 ，也就是说，对于任意的 1 <= i < arr.length （数组下标从 0 开始），都满足 abs(arr[i] - arr[i - 1]) <= 1 。abs(x) 为 x 的绝对值。
        你可以执行以下 2 种操作任意次：

        减小 arr 中任意元素的值，使其变为一个 更小的正整数 。
        重新排列 arr 中的元素，你可以以任意顺序重新排列。
        请你返回执行以上操作后，在满足前文所述的条件下，arr 中可能的 最大值 。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/maximum-element-after-decreasing-and-rearranging
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class Medium1846 {
    public static void main(String[] args) {
        int[] arr = {2,2,1,2,1};
        int[] arr2 = {100,1,1000};

        System.out.println(new Medium1846().maximumElementAfterDecrementingAndRearranging2(arr2));
    }
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int len=arr.length;
        if(len==1) return 1;
        int n =1;
        Arrays.sort(arr);
        arr[0]=1;
        for(int i =1;i<len;i++){
            if(arr[i]!=arr[i-1]) arr[i] = arr[i-1]+1;
        }

        return  arr[len-1];
    }
    public int maximumElementAfterDecrementingAndRearranging2(int[] arr) {
        int len=arr.length;
        if(len==1) return 1;
        int miss=0;
        int[] cnt =new int[len+1];
        for(int i =0;i<len;i++){
            if(arr[i]>len) arr[i]=len;
            cnt[arr[i]] ++;
        }
        for(int i =1;i<len+1;i++){
            while(cnt[i]>1 && miss>0) {
                cnt[i] --;
                miss--;
            }
           if(cnt[i]==0) miss++;
        }

        return  len-miss;
    }
}
