package com.LeeCode.Medium;

import java.lang.reflect.Array;
import java.util.*;

public class Medium15 {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4,-2,-3,3,0,4};
        Medium15.threeSum(nums);

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        if (nums.length < 3) return ans;

        Arrays.sort(nums);
        int first;
        int second = 0;
        int third = 0;
        int k;
        for (int i = 0; i < nums.length - 2; i++) {
            k = nums.length - 1;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            first = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                second = nums[j];
                while (k > j && first + second + nums[k] > 0) k--;

                if (k == j) break;

                if (first + second + nums[k] == 0) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(first);
                    list.add(second);
                    list.add(nums[k]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
