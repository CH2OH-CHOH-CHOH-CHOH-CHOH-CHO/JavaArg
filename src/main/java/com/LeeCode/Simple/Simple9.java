package com.LeeCode.Simple;
//给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
//
//        回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/palindrome-number
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class Simple9 {
    public static void main(String[] args) {
        System.out.println(Simple9.isPalindrome2(-1));
    }

    public static boolean isPalindrome(int x ){
        if(x<0) return false;
        else {
            char[] ch = String.valueOf(x).toCharArray();
            int i = ch.length;
            if(i==1) return true;

            while(ch.length-(i)<=i-1){
                if(ch[ch.length-i]!=ch[i-1]) return false;
                i--;
            }
            return true;

        }
    }

    public static boolean isPalindrome2(int x){
        int rev =0;
        if(x<0) return false;
        if(x>=0 && x<10) return true;
        if(x%10==0) return false;
        while(rev <x) {
            rev=rev*10+x%10;
            x=x/10;
        }

        if(x==rev) return true;
        else if(rev/10==x) return true;
        else return  false;
    }
}
