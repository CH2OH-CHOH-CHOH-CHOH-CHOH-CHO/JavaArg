package com.LeeCode.Simple;

public class Simple563 {

    public static void main(String[] args) {
        TreeNode t= new TreeNode(
                4,new TreeNode(2,new TreeNode(3),new TreeNode(5)),
                new TreeNode(9,null,new TreeNode(7)));
        System.out.println(new Simple563().findTilt(t));
    }
     public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

    public int findTilt(TreeNode root) {
         if(root==null)return 0;
        return Tilt(root)+ TiltSum(root);

    }

    private int sum(TreeNode t){
        if(t==null) return 0;
        int left =0;
        int right =0;
        if(t.left!=null) left =sum(t.left);

        if (t.right!=null) right =sum(t.right);

        return t.val+left+right;
    }

    private int Tilt(TreeNode t){
        return Math.abs(sum(t.right)-sum(t.left));
    }

    private int TiltSum(TreeNode t){
         int left =0;
         int right =0;
        if(t.left!=null) {
            left =Tilt(t.left)+TiltSum(t.left);
        }

        if (t.right!=null) {
            right =Tilt(t.right)+TiltSum(t.right);
        }

        return left+right;
    }
}
