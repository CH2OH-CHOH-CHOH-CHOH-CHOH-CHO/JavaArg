package com.LeeCode.Offer;

public class B116 {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind unionFind = new UnionFind(n);
        for(int i = 0;i<n;i++){
            for(int j =i;j<n;j++){
                if(isConnected[i][j]==1){
                    unionFind.merge(i,j);
                }
            }
        }

        return unionFind.unionNumber();
    }

    class UnionFind{

        private int[] fa ;
        private int[] rank;
        public UnionFind(int size) {
            this.fa = new int[size];
            this.rank = new int[size];
            for(int i = 0;i<size;i++){
                this.fa[i]=i;
                rank[i] = 1;
            }
        }

        private int find(int x) {
            if(x == fa[x])
                return x;
            else{
                return fa[x]= find(fa[x]);         //返回父节点
            }
        }

        private void merge(int i, int j){
            int x = find(i), y = find(j);    //先找到两个根节点
            if (rank[x] <= rank[y])
                fa[x] = y;
            else
                fa[y] = x;

            if (rank[x] == rank[y] && x != y)
                rank[y]++;                   //如果深度相同且根节点不同，则新的根节点的深度+1
        }

        public boolean isUnion(int i,int j){
            return find(i) == find(j);
        }

        public int unionNumber(){
            int n = 0;
            for(int i = 0;i<fa.length;i++){
                if(fa[i]==i) n++;
            }
            return n;
        }
    }

}
