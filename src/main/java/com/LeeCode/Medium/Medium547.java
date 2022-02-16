package com.LeeCode.Medium;


/*有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。

        省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。

        给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。

        返回矩阵中 省份 的数量。

         

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/number-of-provinces
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class Medium547 {
    public static void main(String[] args) {
       int[][] isConnected = new int[][]{{1,1,0}, {1,1,0},{0,0,1}};
        System.out.println(new Medium547().findCircleNum(isConnected));
    }

    class UnionFind{
        int[] fa;
        int[] rank;
        int size;

        public UnionFind(int size) {
            this.fa = new int[size];
            this.rank = new int[size];
            this.size = size;
            for(int i = 0;i<size;i++){
                fa[i] = i;
                rank[i] =1;
            }
        }

        private int find(int p){
            if (p != fa[p]) fa[p] = find(fa[p]);
            return fa[p];
        }

        public boolean isConnected(int f, int s){
            return find(f)==find(s);
        }

        public void union(int f, int s){
            int fistRoot = find(f);
            int secondRoot = find(s);
            if(fistRoot==secondRoot) return;

            if(rank[fistRoot]<rank[secondRoot]){
                fa[fistRoot] = secondRoot;
            }
            else if(rank[fistRoot]>rank[secondRoot]){
                fa[secondRoot] = fistRoot;
            }
            else {
                fa[fistRoot] = secondRoot;
                rank[secondRoot]++;
            }
        }

        public int numIsolate(){
            int num =0;
            for(int i = 0;i<size;i++){
                if (i == fa[i]) num++;
            }
            return num;
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int lenMax = isConnected.length;
        UnionFind unionFind = new UnionFind(lenMax);

        for(int i = 0;i<lenMax;i++){
            for(int j = i;j<lenMax;j++){
                if(isConnected[i][j]==1){
                    unionFind.union(i,j);
                }
            }
        }

        return unionFind.numIsolate();
    }
}
