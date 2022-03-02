package com.LeeCode.Offer;

public class A55_2 {
    public boolean isBalanced(TreeNode root) {

        if (root==null) return true;
        return dfs(root)>=0;
    }

    private int dfs(TreeNode node){
        int l = 0;
        int r = 0;
        if(node.right!=null) r=dfs(node.right);
        if(node.left!=null)  l=dfs(node.left);
        if(l==-1 || r == -1 || Math.abs(l-r)>1) return -1;
        return Math.max(l,r)+1;
    }
}
