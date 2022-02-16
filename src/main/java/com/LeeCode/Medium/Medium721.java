package com.LeeCode.Medium;

import java.util.*;

public class Medium721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String,String> email = new HashMap<>();
        for (List<String> lists : accounts
             ) {
                int size = lists.size();
                for(int i=0;i<size;i++){
                    email.put(lists.get(size-i),lists.get(0));
                }

        }
        String[] strings = (String[]) email.keySet().toArray();
        int n = strings.length;
        UnionFind unionFind = new UnionFind(email.size());
        for(int i =0;i<n;i++){

        }

        return null;

    }

    class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void union(int index1, int index2) {
            parent[find(index2)] = find(index1);
        }

        public int find(int index) {
            if (parent[index] != index) {
                parent[index] = find(parent[index]);
            }
            return parent[index];
        }
    }
}
