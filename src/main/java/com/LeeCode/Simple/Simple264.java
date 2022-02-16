package com.LeeCode.Simple;
/*给你一个整数 n ，请你找出并返回第 n 个 丑数 。

        丑数 就是只包含质因数 2、3 和/或 5 的正整数。*/
import java.util.HashSet;
import java.util.Set;
/*
* 动态规划法：相当于三个数组由三个指针指向它，每次前进最小的一步，就可以得到前进n步的数是多少
* 堆与集合法：集合用于去重，堆原始值为1，每次取出最小值并将取出值的*2，*3，*5加入堆中。
*           这种方法类似于广度优先搜索的方法，也可用于树的层序遍历。
*
*
* */
public class Simple264 {
    public int nthUglyNumber1(int n) {
        if(n<6) return n;
        int nums=1;
        int i=2;
        int ans ;
        while(true){
            ans=i;
            while(ans%5==0) ans=ans/5;
            while(ans%3==0) ans=ans/3;
            while(ans%2==0) ans=ans/2;
            if(ans==1)  nums++;
            if(nums==n) return i;
            i++;
        }
    }
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if (dp[i] == num2) {
                p2++;
            }
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
        }
        return dp[n];
    }
}
