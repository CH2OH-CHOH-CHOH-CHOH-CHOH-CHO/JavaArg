package com.LeeCode.Hard;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class H51 {
    public static void main(String[] args) {
        new H51().totalNQueens(4);
    }
    int ans = 0;
    boolean[][] canPlace;

    public int totalNQueens(int n) {
        canPlace = new boolean[n][n];
        for(int i = 0;i<n;i++){
            Arrays.fill(canPlace[i],true);
        }

        dfs(n,0);
        return ans;
    }

    private void dfs(int n,int layer){
        if(layer==n) {
            ans++;
            return;
        }

        for(int i = 0;i<n;i++){
            if(canPlace[layer][i]){
                boolean[][] temp = new boolean[n][];
                for(int k = 0;k<n;k++){
                    temp[k] = Arrays.copyOf(canPlace[k],n);
                }

                for(int p=0;p<n;p++){
                    for (int q = 0;q<n;q++){
                        if(layer+i==p+q || layer-i==p-q || q==i)  canPlace[p][q]=false;
                    }
                }

                dfs(n,layer+1);

                canPlace = temp;

            }
        }
    }
}
