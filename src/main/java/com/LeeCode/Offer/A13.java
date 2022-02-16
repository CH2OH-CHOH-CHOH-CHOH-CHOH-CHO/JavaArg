package com.LeeCode.Offer;

public class A13 {
    public static void main(String[] args) {
        new A13().movingCount(1,2,1);
    }
    public int movingCount(int m, int n, int k) {
        boolean[][] isCover = new boolean[m][n];
        isCover[0][0] = true;
        DFS(isCover, 0, 0, k);
        int nums = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(isCover[i][j]){
                    nums++;
                }
            }
        }
        return nums;
    }

    private void DFS(boolean[][] isCover,int i,int j,int k){
        int m = isCover.length;
        int n = isCover[0].length;
        if(i+1<m && get(i+1)+get(j)<=k && isCover[i+1][j]==false){
            isCover[i+1][j] = true;
            DFS(isCover,i+1,j,k);
        }
        if(j+1<n && get(i)+get(j+1)<=k && isCover[i][j+1]==false){
            isCover[i][j+1] = true;
            DFS(isCover,i,j+1,k);
        }
        if(i-1>=0 && get(i-1)+get(j)<=k && isCover[i-1][j]==false){
            isCover[i-1][j] = true;
            DFS(isCover,i-1,j,k);
        }
        if(j-1>=0 && get(i)+get(j-1)<=k && isCover[i][j-1]==false){
            isCover[i][j-1] = true;
            DFS(isCover,i,j-1,k);
        }
    }

    private int get(int x ){
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;

    }
}
