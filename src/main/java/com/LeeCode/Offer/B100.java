package com.LeeCode.Offer;

import jdk.internal.org.objectweb.asm.tree.MultiANewArrayInsnNode;
import sun.awt.util.IdentityArrayList;

import java.util.ArrayList;
import java.util.List;

public class B100 {
    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(2);
        List<Integer> l2 = new ArrayList<>();
        l2.add(3);
        l2.add(4);
        List<Integer> l3 = new ArrayList<>();
        l3.add(6);
        l3.add(5);
        l3.add(7);
        List<Integer> l4 = new ArrayList<>();
        l4.add(4);
        l4.add(1);
        l4.add(8);
        l4.add(2);

        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        lists.add(l4);
        new B100().minimumTotal(lists);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j ==0) {
                    dp[i][j] = triangle.get(i).get(j) +  dp[i-1][j];
                } else if(j==i){
                    dp[i][j] = triangle.get(i).get(j) +  dp[i-1][j-1];
                }
                else {
                    dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i-1][j],dp[i-1][j-1]);
                }

            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, dp[n - 1][i]);
        }
        return min;
    }
}
