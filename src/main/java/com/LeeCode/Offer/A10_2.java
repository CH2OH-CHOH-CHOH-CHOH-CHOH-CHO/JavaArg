package com.LeeCode.Offer;

public class A10_2 {
    public int numWays(int n) {

        final int MOD = 1000000007;
        if (n <2) {
            return 1;
        }
        int p = 0, q = 1, r = 1;
        for (int i = 2; i <= n; ++i) {
            p = q;
            q = r;
            r = (p + q) % MOD;
        }
        return r;

    }
}
