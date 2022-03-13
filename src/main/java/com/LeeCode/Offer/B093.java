package com.LeeCode.Offer;

import java.util.HashMap;

public class B093 {
    public int lenLongestFibSubseq(int[] arr) {
        int len = arr.length;
        int ans = 0;
        int[][] dp = new int[len][len];
        HashMap<Integer,Integer> hashMap = new HashMap();
        for(int i = 0;i<len;i++){
            hashMap.put(arr[i],i);
        }

        for(int i = 1;i<len;i++){
            for(int j = i-1;j>=0;j--){
                 int sub = arr[i]-arr[j];
                 if(sub>=arr[j]) break;
                 if(hashMap.containsKey(sub)){
                     dp[i][j] = Math.max(2,dp[j][hashMap.get(sub)])+1;
                     ans=Math.max(ans,dp[i][j]);
                 }
            }
        }
        return ans;
    }
}
