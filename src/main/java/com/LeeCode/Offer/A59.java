package com.LeeCode.Offer;

import java.util.LinkedList;

public class A59 {
    public static void main(String[] args) {
        new A59().maxSlidingWindow(new int[]{7, 2, 4}, 2);
    }
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        if(n==0) return new int[0];
        LinkedList<Integer> linkedList = new LinkedList<>();
        int[] ans = new int[n-k+1];
        for(int i=0;i<k;i++){
            while(!linkedList.isEmpty() && nums[linkedList.peekLast()]<=nums[i]){
                linkedList.pollLast();
            }
            linkedList.offerLast(i);
        }
        ans[0] = nums[linkedList.peek()];
        for(int i =k;i<n;i++){
            while(!linkedList.isEmpty() && nums[linkedList.peekLast()]<=nums[i]){
                linkedList.pollLast();
            }
            linkedList.offerLast(i);
            while(linkedList.peek() <= i -k){
                linkedList.pollFirst();
            }
            ans[i-k+1] = nums[linkedList.peek()];

        }
        return ans;
    }
}
