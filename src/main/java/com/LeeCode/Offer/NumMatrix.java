package com.LeeCode.Offer;//013
//给定一个二维矩阵 matrix，以下类型的多个请求：
//
//        计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。
//        实现 NumMatrix 类：
//
//        NumMatrix(int[][] matrix) 给定整数矩阵 matrix 进行初始化
//        int sumRegion(int row1, int col1, int row2, int col2) 返回左上角 (row1, col1) 、右下角 (row2, col2) 的子矩阵的元素总和。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/O4NDxx
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


/*
* 主要思想是计算一维或二维数组的前缀和，通过前缀和的差值计算两个坐标之间的和，减少多次重复运算的时间复杂度
* 技巧有:计算前缀和时，可以使前缀和数组比原始数组多出一位，这样可以让[0]处的值默认为0，不必考虑临界情况
*       计算两个坐标之和的差值是简单的前缀和作差
*       需要判断矩阵的临界情况，行或列。
* */
/*public class NumMatrix {
    int[][] sums1;
    public NumMatrix(int[][] matrix) {
        int m =matrix.length;

        if(m>0) {
            int n = matrix[0].length;
            sums1 = new int[m][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 1; j < n+1; j++)
                    sums1[i][j] = sums1[i][j-1]+matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int i = row1;i<=row2;i++){
            sum+=sums1[i][col2+1]-sums1[i][col1];
        }
        return sum;
    }
}*/

public class NumMatrix {
    int[][] sums2;
    public NumMatrix(int[][] matrix) {
        int m =matrix.length;

        if(m>0) {
            int n = matrix[0].length;
            sums2 = new int[m+1][n+1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++)
                    sums2[i+1][j+1] = sums2[i+1][j]+sums2[i][j+1]-sums2[i][j]+matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        int sum=sums2[row2+1][col2+1]-sums2[row2+1][col1]-sums2[row1][col2+1]+sums2[row1][col1];
        return sum;
    }
}
