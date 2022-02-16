package com.LeeCode.Offer;

public class A15 {
    public static void main(String[] args) {
        System.out.println(new A15().hammingWeight(11));
    }
    public int hammingWeight(int n) {
        int nums= 0;
        while(n!=0){
            if(n%2==0) ;
            else {
                nums++;
            }
            n=n>>1;

        }
        return nums;
    }
}
