package com.LeeCode.Hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*239. 滑动窗口最大值
        给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。

        返回滑动窗口中的最大值。*/
public class Hard239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]!=o2[0]? o2[0]-o1[0]:o2[1]-o1[1];
            }
        });

        int[] T = new int[n - k + 1];

        for(int i = 0;i<k;++i){
            pq.offer(new int[]{nums[i],i});
        }
        T[0]=pq.peek()[0];
        for(int i =k;i<n;i++){
            pq.offer(new int[]{nums[i],i});
            while(pq.peek()[1]<i-k+1) pq.poll();

            T[i-k+1]=pq.peek()[0];
        }

        return T;
    }
}
