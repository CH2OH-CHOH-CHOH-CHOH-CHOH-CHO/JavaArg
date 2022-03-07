package com.LeeCode.Offer;

public class B019 {
    public static void main(String[] args) {
         new B019().validPalindrome("abc");
    }
    public boolean validPalindrome(String s) {
        int right= s.length()-1;
        int left = 0;
        while(left<right){
            if(s.charAt(left)==s.charAt(right)){
                left++;
                right--;
            }
            else if(isPalindrome(s,left+1,right) || isPalindrome(s,left,right-1)) return true;
            else return false;
        }
        return true;
    }
    private boolean isPalindrome(String s, int left , int right){
        while (left < right){
            if (s.charAt(left++) != s.charAt(right--))
                return false;
        }
        return true;
    }

}
