package com.LeeCode.Simple;
/*给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。

        丑数 就是只包含质因数 2、3 和/或 5 的正整数。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/ugly-number
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class Simple263 {
    public boolean isUgly(int n) {
        while(n>1){
            if(n%5==0||n%10==0) n=n/5;
            else if(n%2==0) n=n/2;
            else if(n%3==0) n=n/3;
            else break;
        }
        if(n==1) return true;
        else return false;
    }
}
