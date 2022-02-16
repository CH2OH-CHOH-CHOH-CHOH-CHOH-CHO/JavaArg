package com.LeeCode.Offer;


import java.util.Arrays;

public class A07 {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3};
        int[] b = new int[]{3,2,1};

        new A07().buildTree(a,b);
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null || preorder.length==0) return null;
        if(inorder==null || inorder.length==0) return null;
        int[] leftChildPreorder = null;
        int[] leftChildInorder= null;
        int[] rightChildPreorder= null;
        int[] rightChildInorder= null;
        TreeNode root = new TreeNode(preorder[0]);

        //谁是左子树最后的节点
        int indexRoot =0;
        for(int i = 0;i<inorder.length;i++){
            if(inorder[i]==preorder[0]){//找到根节点
                leftChildInorder = Arrays.copyOfRange(inorder,0,i);
                if(i!=inorder.length-1){
                    rightChildInorder = Arrays.copyOfRange(inorder,i+1,inorder.length);
                }
                indexRoot = i;
            }
        }



        leftChildPreorder = Arrays.copyOfRange(preorder,1,indexRoot+1);
        if(indexRoot!=preorder.length-1){
            rightChildPreorder = Arrays.copyOfRange(preorder,indexRoot+1,inorder.length);
        }


        root.left = this.buildTree(leftChildPreorder,leftChildInorder);
        root.right = this.buildTree(rightChildPreorder,rightChildInorder);

        return root;
    }
}
