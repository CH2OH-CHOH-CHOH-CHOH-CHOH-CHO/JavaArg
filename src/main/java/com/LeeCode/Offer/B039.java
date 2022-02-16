package com.LeeCode.Offer;

public class B039 {
    public static void main(String[] args) {
        System.out.println(new B039().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }
    public int largestRectangleArea(int[] heights) {

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
    }
}
