package com.LeeCode.Medium;

public class Medium684 {
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
    public int[] findRedundantConnection(int[][] edges) {
        int len = edges.length;
        int[] find = null;
        UnionFind unionFind = new UnionFind(len);
        for(int i =0;i<len;i++){
            if(unionFind.isConnected(edges[i][0]-1,edges[i][1]-1)){
                find =  edges[i];
                break;
            }
            else unionFind.union(edges[i][0]-1,edges[i][1]-1);
        }
        return find;
    }
}
