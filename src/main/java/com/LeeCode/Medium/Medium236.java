package com.LeeCode.Medium;


public class Medium236 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
       public TreeNode(int x) { val = x; }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Medium236 medium236 = new Medium236();
        Medium236.TreeNode n2 = new Medium236().new TreeNode(2);
        Medium236.TreeNode n1 = new Medium236().new TreeNode(1,n2,null);
        new Medium236().lowestCommonAncestor(n1,n2,n1);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        while(true){
            if(p==q) return p;
            if(DFS(p,q)==null) p=DFS(root,p);
            else return p;
        }
    }

    //找到一棵树的父亲
    private TreeNode DFS(TreeNode root, TreeNode t){
        if(root==null) return null;
        if(root.left!=null ) {
            if(root.left==t) return root;
            else {
                TreeNode temp =  DFS(root.left,t);
                if(temp!=null) return temp;
            }
        }
        if(root.right!=null ) {
            if(root.right==t) return root;
            else {
                TreeNode temp =  DFS(root.right,t);
                if(temp!=null) return temp;
            }
        }
        return null;
    }
}
