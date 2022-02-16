package com.LeeCode.Medium;

public class Mediun33 {
    public int search(int[] nums, int target) {
        int len =nums.length;
        if (len == 0) {
            return -1;
        }
        if (len == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int l=0,r=len-1;
        while(l<=r){
            int mid = (l+r)/2;
            //找到了 直接返回
            if (target==nums[mid]) return mid;
            //如果左边一定有序，右边部分有序
            //这里总是用nums[0]判断，因为它一定是分界点
            if(nums[0]<=nums[mid]) {
                //如果目标值在左边（一定有序的一边）
                //这里使用一定有序的一边做判断，不满足则是部分有序的情况
                if(nums[0]<=target && target<nums[mid]){
                    r = mid-1;
                }
                //如果目标值在右边
                else {
                    l = mid+1;
                }
            }
            //如果右边一定有序，左边部分有序
            else {
                //如果目标值在右边
                if(nums[mid] <target && target<=nums[len-1]){
                    l = mid+1;
                }
                //如果目标值在左边
                else {
                    r = mid-1;
                }
            }
        }
        return -1;
    }
}
