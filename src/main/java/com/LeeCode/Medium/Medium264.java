package com.LeeCode.Medium;

import java.util.HashSet;
import java.util.Set;

public class Medium264 {
    public int nthUglyNumber(int n) {
        if(n<6) return n;
        Set<Integer> set = new HashSet<>();
        int nums=1;
        set.add(1);
        int i=2;
        int ans = 0;
        while(true){
            ans=i;
            if(i%5==0) ans=i/5;
            else if(i%2==0) ans=i/2;
            else if(i%3==0) ans=i/3;
            if(set.contains(ans)) {
                set.add(i);
                nums++;
            }
            if(nums==n) return i;
            else i++;
        }
    }
}
