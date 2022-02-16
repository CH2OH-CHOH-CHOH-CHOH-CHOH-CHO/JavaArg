package com.LeeCode.Medium;

public class Medium114 {
      public class TreeNode {
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
    
    public void flatten(TreeNode root) {
        if(root!=null){
            TreeNode next= root;
            while (next!=null){
                if(next.right==null) {
                    next.right=next.left;
                    next.left=null;
                    next = next.right;
                    continue;
                }
                else if(next.left!=null){
                    TreeNode left = next.left;
                    while(left.right!=null) left = left.right;
                    left.right = next.right;
                    next.right=null;
                }
                else {
                    next = next.right;
                }


            }
        }
    }


}
