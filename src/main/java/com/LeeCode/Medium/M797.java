package com.LeeCode.Medium;

import java.util.ArrayList;
import java.util.List;

public class M797 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        dfs(graph, 0);
        return ans;
    }

    private void dfs(int[][] graph,int index){
        if(index ==graph.length-1){
            path.add(index);
            List<Integer> copy = new ArrayList<>(path);
            ans.add(copy);
            path.remove(path.size()-1);
            return;
        }

        for(int i = 0;i<graph[index].length;i++){
            path.add(index);

            dfs(graph,graph[index][i]);

            path.remove(path.size()-1);
        }
    }
}
