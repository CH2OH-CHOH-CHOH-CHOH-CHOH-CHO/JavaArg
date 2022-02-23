package com.LeeCode.Offer;

public class A54 {
    int num = 0;
    int res = 0;
    public int kthLargest(TreeNode root, int k) {

        midTraverse(root,k);
        return res;
    }

    private void midTraverse(TreeNode root, int k){
        if(root==null) return;


        if(num<k) midTraverse(root.right,k);

        if(++num==k) res =  root.val;

        if(num<k) midTraverse(root.left,k);

    }
}
