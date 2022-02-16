package com.LeeCode.Simple;

import java.util.HashMap;
import java.util.Map;

public class Simple13 {
    public static void main(String[] args) {



        System.out.println(Simple13.romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int i = 0;
        int sum = 0;
        int now = 0;
        int next = 0;
        for(;i<s.length();i++) {
            now = map.get(s.charAt(i));
            if(i<s.length()-1) {
                i++;
                next = map.get(s.charAt(i));
                if (now < next) sum = sum + next - now;
                else if (now == next) sum = sum + now + next;
                else {
                    sum = sum + now + romanToInt(s.substring(i));
                    break;
                }
            }
            else sum = sum +now;
        }
        return sum;

    }
}
