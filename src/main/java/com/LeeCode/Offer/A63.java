package com.LeeCode.Offer;

public class A63 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int min = Integer.MAX_VALUE;
        for (int i:prices
             ) {
            min = Math.min(min,i);
            profit = Math.max(profit,Math.max(0, i - min));
        }
        return profit;
    }
}
