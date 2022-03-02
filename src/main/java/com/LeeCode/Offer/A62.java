package com.LeeCode.Offer;

public class A62 {
    public static void main(String[] args) {
        new A62().lastRemaining(5,3);
    }
        public int lastRemaining(int n, int m) {
            int f = 0;
            for (int i = 2; i < n + 1; ++i) {
                f = (m + f) % i;
            }
            return f;
        }
}
