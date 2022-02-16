package com;

import org.junit.Test;


public class Demo {
    @Test
    public void Test5(){
        System.out.println(Integer.parseInt("123"));
    }

    @Test
    public void Test4(){
        String s = "abcsdfsa";
        System.out.println(s.substring(0,1));
    }
    @Test
    public void Test1(){
        int[] arr = new int[]{1,2,5,3,9,4,5,7,6};
        for (int i:arr
             ) {
            System.out.println(i);
        }
    }
    @Test
    public void Test2(){
        int[] arr = new int[20];
        arr[0]=1;
        arr[0]=2;
        arr[0]=3;
        arr[0]=4;
        arr[0]=5;
        arr[0]=6;
        for (int i:arr
        ) {
            System.out.println(i);
        }
    }

    @Test
    public void Test3(){
        Integer[] arr = new Integer[20];
        arr[1]=1;
        for (int i:arr
        ) {
            System.out.println(i);
        }
    }

}
