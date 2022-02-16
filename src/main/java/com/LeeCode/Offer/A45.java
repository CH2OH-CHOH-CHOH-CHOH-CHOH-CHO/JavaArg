package com.LeeCode.Offer;

public class A45 {
    public String minNumber(int[] nums) {
        return null;
    }
    private boolean compareTo(int a, int b){
        String sa = a+b+"";
        String sb = b+a+"";
        if(Integer.parseInt(sa)>=Integer.parseInt(sb)){
            return true;
        }
        else return false;
    }
}
