package com.LeeCode.Simple;

public class Simple1281 {
    public static void main(String[] args) {
        System.out.println(new Simple1281().subtractProductAndSum(234));
    }
    public int subtractProductAndSum(int n) {
        String s = String.valueOf(n);
        int sum = 0;
        int mul = 1;
        for(int i = 0;i<s.length();++i){
            int a=Integer.valueOf(s.charAt(i))-48;
            System.out.println(a);
            sum = a+sum;
            mul = a*mul;
        }
        return mul-sum;
    }
}
