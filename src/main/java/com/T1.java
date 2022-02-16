package com;

public class T1 {
    public static void main(String[] args) {
        String s ="pc12,235,234,5,6,6,3332,3,321sfwfeg";
        StringBuilder s2=new StringBuilder("");
        for(int i =0;i<s.length();i++){
            if(s.charAt(i)>'9' || s.charAt(i)< '0') {
                if(s2.equals("")) continue;
                System.out.println(s2);
                s2 = new StringBuilder("");
            }
            else s2.append(s.charAt(i));
        }
    }
}
