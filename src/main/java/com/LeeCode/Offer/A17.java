package com.LeeCode.Offer;

public class A17 {
    public int[] printNumbers(int n) {
        int len = (int) Math.pow(10,n);
        int[] arr = new int[len];
        for(int i=0;i<len-1;i++){
            arr[i] = i+1;
        }
        return arr;
    }
}
