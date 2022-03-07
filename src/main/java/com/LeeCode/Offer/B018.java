package com.LeeCode.Offer;

public class B018 {
    public static void main(String[] args) {
         new B018().isPalindrome("A man, a plan, a canal: Panama");
    }
    public boolean isPalindrome(String s) {
        int right = s.length()-1;
        int left = 0;

        while(left<right){
            while(!(Character.isLetterOrDigit(s.charAt(left)) )&& left<right){
                left++;
            }
            while(!(Character.isLetterOrDigit(s.charAt(right)))&& left<right){
                right--;
            }
            if(Character.toUpperCase(s.charAt(left))==Character.toUpperCase(s.charAt(right))){
                left++;
                right--;
            }
            else return false;
        }
        return true;
    }
}
