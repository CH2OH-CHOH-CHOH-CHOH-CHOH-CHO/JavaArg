package com.LeeCode.Offer;

public class B052 {
    TreeNode curr ;
    public TreeNode increasingBST(TreeNode root) {
        if(root==null) return null;
        TreeNode dummyNode = new TreeNode(-1);
        curr = dummyNode;
        middle(root);
        return dummyNode.right;
    }

    public void middle(TreeNode root){
        if(root.left!=null){
            middle(root.left);
        }
        curr.right = root;
        root.left=null;
        curr = curr.right;
        if(root.right!=null){
            middle(root.right);
        }


    }
}
