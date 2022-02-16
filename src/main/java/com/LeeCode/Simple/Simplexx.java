package com.LeeCode.Simple;

public class Simplexx {
    public static void main(String[] args) {
        int[] a = new int[]{0,1,0,3,12};
        new Simplexx().moveZeroes(a);
        for (int i :a
             ) {
            System.out.println(i);

        }
    }
    public void moveZeroes(int[] nums) {
        int zeros=0;
        int indexZero=0;
        int len=nums.length;
        for(int i = 0;i<len;i++){
            if(nums[i]==0) zeros++;
            else if(zeros>0){
                indexZero=scan(nums,0,i);
                swap(nums,i,indexZero);
            }
        }
        for(int i = len-1;i>=0;i--){
            if(zeros>0) {
                nums[i]=0;
                zeros--;
            }
            else break;
        }
    }
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    private static int scan(int[] a, int m, int n) {
        for(int i =m;i<n+1;i++){
            if(a[i]==0) return i;
         }
        return -1;
    }
}
