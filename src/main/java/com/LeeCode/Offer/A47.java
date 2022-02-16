package com.LeeCode.Offer;

public class A47 {
    public static void main(String[] args) {
        new A47().maxValue(new int[][]{{1, 2, 5}, {3, 2, 1}});
    }
    public int maxValue(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        int a;
        int b;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(i>0) a = dp[i-1][j];
                else a = 0;
                if(j>0) b=dp[i][j-1];
                else b=0;
                dp[i][j] = grid[i][j]+Math.max(a,b);
            }
        }
        return dp[row-1][col-1];
    }
}
