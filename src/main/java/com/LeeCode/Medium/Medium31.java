package com.LeeCode.Medium;

public class Medium31 {
    public static void main(String[] args) {
        int[] nums=new int[]{2,5,4,3,1};
        new Medium31().nextPermutation(nums);
        for (int i:nums
             ) {
            System.out.println(i);

        }
    }
    public void nextPermutation(int[] nums) {
        int len =nums.length;
        boolean isChange =false;
        for(int i = len-2;i>=0;--i){
            int min = Integer.MAX_VALUE;
            int index=0;
            //从右往左找，找到一个比现在的数大的数，一定刚好比他大，否则前面已经开始交换过了
            for(int j =len-1;j>i;--j){
                if(nums[i]<nums[j]) {
                    min =Math.min(min, nums[j]);
                    index = j;
                    break;
                }
            }
            if(min!=Integer.MAX_VALUE){
                Medium31.swap(nums,i,index);
                for(int j=i+1;j<i+1+(len-i)/2;++j){
                    Medium31.swap(nums,j,len-j+i);
                }
                isChange=true;
                break;
            }
        }
        if(!isChange){
            for(int j=0;j<(len)/2;++j){
                Medium31.swap(nums,j,len-1-j);
            }
        }
    }
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
