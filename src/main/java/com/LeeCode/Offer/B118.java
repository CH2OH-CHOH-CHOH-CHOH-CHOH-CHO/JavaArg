package com.LeeCode.Offer;

public class B118 {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n+1);
        for(int i = 0;i<n;i++){
            if(uf.isUnion(edges[i][0],edges[i][1])){
                return edges[i];
            }
            else uf.merge(edges[i][0],edges[i][1]);
        }
        return null;
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
