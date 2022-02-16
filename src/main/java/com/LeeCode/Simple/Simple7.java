package com.LeeCode.Simple;
//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
//
//        如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
//
//        假设环境不允许存储 64 位整数（有符号或无符号）。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/reverse-integer
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class Simple7 {
    public static void main(String[] args) {
        System.out.println(Simple7.reverse1(-2147483647));
    }

    public static int reverse1(int x){
        int flag =0;
        if(x<0) {
            x=Math.abs(x);
            flag =1;
        }

        char[] s = String.valueOf(x).toCharArray();
        int i = s.length;
        char[] t= new char[i];
        for(;i>0;i--){
            t[t.length-i] = s[i-1];
        }
        System.out.println(t);
        x = Integer.parseInt(new String(t));

        if(flag==1) return -x;
        else return x;
    }


}
