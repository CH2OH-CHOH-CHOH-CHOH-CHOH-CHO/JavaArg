package com.LeeCode.Medium;

public class Medium59 {
    public int[][] generateMatrix(int n) {
        int[][] a = new int[n][n];
        int num = 1;
        int cycle = 0;
        int i = 0, j = 0;
        a[0][0] = 1;
        while (num < Math.pow(n, 2)) {
            while (j+1 < n - cycle) a[i][++j] = ++num;
            while (i+1 < n - cycle) a[++i][j] = ++num;
            while (j-1 >= cycle) a[i][--j] = ++num;
            cycle = cycle + 1;
            while (i-1 >= cycle) a[--i][j] = ++num;
        }


        return a;
    }
}
