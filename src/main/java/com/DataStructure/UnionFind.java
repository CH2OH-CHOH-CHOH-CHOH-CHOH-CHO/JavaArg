package com.DataStructure;

public class UnionFind {
    private int[] fa;
    private int[] rank;
    private int size;

    public UnionFind(int size){
        this.size=size;
        fa = new int[size];
        rank = new int[size];
        for(int i =0;i<size;i++){
            fa[i]=i;
            rank[i]=1;
        }
    }

    public int find(int p){
        if (p != fa[p])
            fa[p] = find(fa[p]);
        return fa[p];
    }

    public boolean isConnected(int first, int second){
        return find(first)==find(second);
    }

    public void unionElements(int first, int second){
        int fistRoot = find(first);
        int secondRoot = find(second);
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

    private void printArr() {
        for (int id : this.fa) {
            System.out.print(id + "\t");
        }
        System.out.println();
        for (int id : this.rank) {
            System.out.print(id + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 10;
        UnionFind union = new UnionFind(n);
        System.out.println("初始：");
        union.printArr();

        System.out.println("连接了5 6");
        union.unionElements(5, 6);
        union.printArr();

        union.unionElements(5, 4);
        union.printArr();

        union.unionElements(3, 4);
        union.printArr();


        System.out.println("1  6 是否连接：" + union.isConnected(5, 6));

        System.out.println("1  8 是否连接：" + union.isConnected(3, 6));

        System.out.println(union.find(4));
        System.out.println(union.find(5));
        System.out.println(union.find(6));

    }
}
