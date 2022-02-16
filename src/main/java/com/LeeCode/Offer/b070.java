package com.LeeCode.Offer;

public class b070 {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (mid % 2 == 0) {
                if (nums[mid] == nums[mid + 1]) left = mid + 1;
                else right = mid ;
            } else {
                if (nums[mid] == nums[mid + 1]) right = mid ;
                else left = mid + 1;
            }
        }
        return nums[left];
    }


}
