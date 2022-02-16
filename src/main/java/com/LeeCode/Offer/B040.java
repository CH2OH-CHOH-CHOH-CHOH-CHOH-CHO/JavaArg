package com.LeeCode.Offer;

import java.util.Stack;

public class B040 {
    public int maximalRectangle(String[] matrix) {
        if (matrix==null || matrix.length==0) return 0;
        int row = matrix.length;
        int col = matrix[0].length();
        int[][] heights = new int[row][col];
        int ans = 0;
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                if(matrix[i].charAt(j)=='0') heights[i][j]=0;
                if(matrix[i].charAt(j)=='1') heights[i][j]=1;
            }
        }
        for(int i = 0;i<row;i++){
            for(int j =0;j<col;j++){
                if(i>0 && heights[i][j]>0) heights[i][j]=heights[i][j]+heights[i-1][j];
            }
            ans=Math.max(ans,largestRectangleArea(heights[i]));
        }
        return ans;
    }
/*
* 分治算法对于排序数列时间复杂度太高
* */
/*    private int largestRectangleArea(int[] heights) {

        return largestRectangleArea(heights,0,heights.length-1);
    }

    private int largestRectangleArea(int[] heights,int left,int right){
        int n = right-left+1;
        if(n<=0) return 0;
        int minIndex = left;
        for(int i = left;i<=right;i++){
            if(heights[i] < heights[minIndex]){ //Δ
                minIndex = i;
            }
        }
        int midValue = heights[minIndex]*(right-left+1);
        int leftValue = largestRectangleArea(heights,left,minIndex-1);
        int rightValue = largestRectangleArea(heights,minIndex+1,right);
        return Math.max(Math.max(midValue,leftValue),rightValue);
    }*/

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();//维护一个递增的高度的索引
        //哨兵元素，在原数组头尾各加入一个元素0，代表前后的高度为0
        int[] addDummy = new int[heights.length + 2];
        for(int i = 0; i < heights.length; i++){
            addDummy[i + 1] = heights[i];
        }
        heights = addDummy;
        stack.add(0);
        int maxArea = 0;
        for(int i = 1; i < heights.length; i++){
            while(heights[stack.peek()] > heights[i]){
                int height = heights[stack.pop()];
                int width = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
