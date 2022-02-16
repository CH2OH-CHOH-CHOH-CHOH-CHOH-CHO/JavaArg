package com.LeeCode.Medium;

public class Medium189 {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k=k%len;
        //如果能够除尽，说明构成一个循环
        float remain = len/k;
        if((remain -(int)remain)==0){
            for(int i=0;i<k;i++){
                int temp=nums[i];
                for(int j=0;j<remain;j++){
                    if(j-k<0) nums[j+len-k]=nums[j];
                    else nums[j-k]=nums[j];
                }
            }
        }
    }
}
