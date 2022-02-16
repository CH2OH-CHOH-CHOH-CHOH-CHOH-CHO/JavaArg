package com.LeeCode.Offer;

public class A66 {
    public int[] constructArr(int[] a) {
        if(a.length <= 1) return new int[]{};
        int[] B1 = new int[a.length];
        B1[0] = 1;
        int temp = 1;
        for(int i = 1;i<a.length;i++){
            B1[i] = B1[i-1]*a[i-1];
        }
        for(int i = a.length-2;i>=0;i--){
            temp = temp * a[i+1];
            B1[i] = B1[i]*temp;
        }
        return B1;
    }
}
