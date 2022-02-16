package com.LeeCode.Medium;

import java.util.*;

public class Medium2034 {
    private TreeMap<Integer,Integer> stock ;
    private HashMap<Integer,Integer> stamps;
    private int newTimestamp;
    private int newPrice;

    public Medium2034() {
        this.stock = new TreeMap<>();
        this.stamps = new HashMap<>();
    }

    public void update(int timestamp, int price) {
        if(timestamp>=this.newTimestamp) {
            this.newTimestamp = timestamp;
            this.newPrice = price;
        }

        if(stamps.containsKey(timestamp)){
            int nowPrice = stamps.get(timestamp);
            stock.remove(nowPrice);
            stamps.remove(timestamp);
        }
        stamps.put(timestamp,price);
        stock.put(price,timestamp);

    }

    public int current() {
        return this.newPrice;
    }

    public int maximum() {
        return stock.lastKey();
    }

    public int minimum() {
        return stock.firstKey();

    }
}
