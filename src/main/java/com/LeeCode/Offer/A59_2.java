package com.LeeCode.Offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class A59_2 {
    private LinkedList<Integer> integers;
    private Deque<Integer> queue;
    public A59_2() {
        integers = new LinkedList<>();
        queue = new LinkedList<>();
    }

    public int max_value() {
        if(queue.size()==0) return -1;
        return queue.peekFirst();
    }

    public void push_back(int value) {
        integers.addLast(value);
        while(queue.size()!=0 && queue.peekLast()<value) {
            queue.removeLast();
        }
        queue.addLast(value);
    }

    public int pop_front() {
        if(integers.size()==0) return -1;
        if(queue.peekFirst()==integers.peekFirst()) queue.removeFirst();
        return integers.removeFirst();
    }
}
