package com.LeeCode.Offer;

import java.util.LinkedList;
import java.util.List;

public class A34 {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(11,new TreeNode(7),new TreeNode(2));
        TreeNode b = new TreeNode(4,new TreeNode(5),new TreeNode(1));
        TreeNode root = new TreeNode(5,new TreeNode(4,a,null),new TreeNode(8,new TreeNode(13),b));
        new A34().pathSum(root,22);
    }
    List<List<Integer>> ans = new LinkedList<>();
    LinkedList<Integer> arr = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        LinkedList<Integer> arr = new LinkedList<>();
        dfs(root,target);
        return ans;
    }

    private void dfs(TreeNode treeNode, int remain){
        if (treeNode==null) return;

        arr.offerLast(treeNode.val);
        int res = remain - treeNode.val;

        if(res==0 && treeNode.left==null && treeNode.right==null) {
            LinkedList<Integer> copy = new LinkedList<>();
            for (Integer i: arr
                 ) {copy.add(i);

            }
            ans.add(copy);
        }

        dfs(treeNode.left,res);
        dfs(treeNode.right,res);

        arr.pollLast();
    }

}
