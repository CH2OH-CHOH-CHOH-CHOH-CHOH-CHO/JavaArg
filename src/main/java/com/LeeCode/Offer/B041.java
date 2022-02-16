package com.LeeCode.Offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class B041 {
    Deque<Integer> list = new LinkedList<>();
    int k = 0;
    double sum = 0;
    public B041(int size) {
        this.k =size;
    }

    public double next(int val) {
        if(list.size()!=k) {
            list.offerLast(val);
            sum += val;
        }
        else{
            sum = sum + val-list.pollFirst();
            list.offerLast(val);
        }
        return sum/list.size();
    }
}
