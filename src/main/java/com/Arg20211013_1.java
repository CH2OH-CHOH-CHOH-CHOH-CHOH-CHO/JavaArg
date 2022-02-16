package com;

public class Arg20211013_1 {
    public static void main(String[] args) {
        char[] a ="ASDFCJHG".toCharArray();
        char[] b ="CFAHB".toCharArray();
        char[] bMark = new char[b.length];
        char[] c = new char[a.length];

        for(int i = 0;i<a.length;i++){
            for(int j =0;j<b.length;j++){
                //如果找到相同字符
                if(a[i] == b[j]){
                    bMark[j]=1;
                    c[i]=' ';
                    break;
                }
                //遍历完还没有找到
                else if(j==b.length-1) c[i] = a[i];
            }
        }
        System.out.println(a);
        System.out.println(b);
        //j不清零，反复向前遍历
        int j =0;
        for(int i = 0;i<c.length;i++) {
            if (c[i] == ' '){
                while(bMark[j] != 1){
                    j++;
                }
                System.out.print(b[j]+"");
                j++;
            }
            else System.out.print(c[i]+"");
        }
    }
}
