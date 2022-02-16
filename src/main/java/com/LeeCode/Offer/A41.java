package com.LeeCode.Offer;

import java.util.PriorityQueue;
import java.util.Queue;

public class A41 {
    /** initialize your data structure here. */
    Queue<Integer> A,B;
    public A41() {
        A = new PriorityQueue<>();
        B = new PriorityQueue<>((x,y)->(y-x));  //Δ
    }

    public void addNum(int num) {
        //一定要有数据交换过程，为了排序
        if(A.size()==B.size()){
            B.add(num);
            A.add(B.poll());
        }
        else {
            A.add(num);
            B.add(A.poll());
        }
    }

    public double findMedian() {
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
    }
}
