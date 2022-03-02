package com.LeeCode.Offer;

public class A68 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == p || root==q ) return root;
        if(root.val>p.val && root.val > q.val) return lowestCommonAncestor(root.left,p,q);
        else if(root.val< p.val && root.val< q.val) return lowestCommonAncestor(root.right,p,q);
        else return root;
    }


}
