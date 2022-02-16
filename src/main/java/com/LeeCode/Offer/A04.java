package com.LeeCode.Offer;

public class A04 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        new A04().findNumberIn2DArray(arr,20);
    }
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int i=0;
        int j = col-1;
        while(i<row && j >= 0){
                if(matrix[i][j]==target) return true;
                else if(matrix[i][j]>target){
                    j--;
                }
                else i++;
        }

        return false;
    }
}
