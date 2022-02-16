package com.LeeCode.Simple;
/*泰波那契序列 Tn 定义如下： 

        T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2

        给你整数 n，请返回第 n 个泰波那契数 Tn 的值。

         

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/n-th-tribonacci-number
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class Simple1137 {
    public int tribonacci(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        if(n==2) return 1;
        int n_0 = 0;
        int n_1 = 1;
        int n_2 = 1;
        for(int i =3;i<=n;i++){
            int temp = n_2+n_1+n_0;
            n_0 = n_1;
            n_1 = n_2;
            n_2 = temp;
        }
        return n_2;
    }
}
