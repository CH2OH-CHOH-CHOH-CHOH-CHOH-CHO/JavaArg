package com.LeeCode.Offer;

import java.util.ArrayDeque;

public class A09 {
    private ArrayDeque<Integer> stack1;
    private ArrayDeque<Integer> stack2;
    public A09() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }

    public void appendTail(int value) {
        stack1.offer(value);
    }

    public int deleteHead() {
        while(stack1.peek()!=null) stack2.offer(stack1.poll());
        if(stack2.peek()==null) return -1;
        else return stack2.poll();
    }
}
