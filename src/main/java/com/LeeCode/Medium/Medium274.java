package com.LeeCode.Medium;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * 本题的核心思想是对数组排序，并求H指数，其数学公式的实现可以从数组末尾计数
 * 至H第一个小于值为止。为了优化时间复杂度，可以使用计数排序进行实现。
 *
 *
 *
 * */
class Medium274 {
    public static void main(String[] args) {
        System.out.println(Medium274.hIndex(new int[]{3, 1, 4, 2, 0, 5}));
    }

    public static int hIndex1(int[] citations) {
        int H = 0;
        int i = citations.length - 1;
        Arrays.sort(citations);
        while (H < citations[i] && i >= 0) {
            H++;
            i--;
        }
        return H;
    }

    public static int hIndex(int[] citations) {
        int n = citations.length;
        int[] count = new int[n+1];
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n) {
                count[n]++;
            }else {
                count[citations[i]]++;
            }
        }
        int H=0;
        for(int i =n;i>=0;i--){
            H+=count[i];
            if(H>=i) return i;
        }
        return H;
    }

}