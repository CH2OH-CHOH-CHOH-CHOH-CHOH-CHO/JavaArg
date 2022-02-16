package com.LeeCode.Medium;
/*已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。

        在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。

        给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。

        你必须尽可能减少整个操作步骤。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class Medium81 {
    public boolean search(int[] nums, int target) {
        int len =nums.length;
        if (len == 0) {
            return false;
        }
        if (len == 1) {
            return nums[0]==target;
        }
        int l=0,r=len-1;
        while(l<=r){
            int mid = (l+r)/2;
            //找到了 直接返回
            if (target==nums[mid]) return true;
            //如果左边一定有序，右边部分有序
            //这里总是用nums[0]判断，因为它一定是分界点
            if (nums[l] == nums[mid] && nums[mid] == nums[r]) {
                ++l;
                --r;
            }
            else if(nums[l]<=nums[mid]) {
                //如果目标值在左边（一定有序的一边）
                //这里使用一定有序的一边做判断，不满足则是部分有序的情况
                if(nums[l]<=target && target<nums[mid]){
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
        return false;
    }
}
