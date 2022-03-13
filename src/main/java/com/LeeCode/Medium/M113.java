package com.LeeCode.Medium;

import java.util.ArrayList;
import java.util.List;

public class M113 {
    public static void main(String[] args) {
        new M113().pathSum(new TreeNode(5,new TreeNode(4),new TreeNode(8)),13);
    }
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root==null) return ans;
        dfs(root,0,targetSum);
        return ans;
    }

    private void dfs (TreeNode node,int sum,int targetSum){
        sum += node.val;
        if(node.left==null && node.right==null){
            if(sum==targetSum) {
                path.add(node.val);
                List<Integer> copy = new ArrayList<>(path);
                ans.add(copy);
                path.remove(path.size()-1);
            }
            return;
        }

        if(node.left!=null){
            path.add(node.val);
            dfs(node.left,sum,targetSum);
            path.remove(path.size()-1);
        }

        if(node.right!=null){
            path.add(node.val);
            dfs(node.right,sum,targetSum);
            path.remove(path.size()-1);
        }
    }
}
