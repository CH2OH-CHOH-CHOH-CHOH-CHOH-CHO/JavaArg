package com.LeeCode.Offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class A32_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        if(root==null) return ans;

        treeNodes.add(root);

        while(treeNodes.size()!=0){
            ArrayList<Integer> integers = new ArrayList<>();
            int len = treeNodes.size();
            for(int i = 0;i<len;i++){
                TreeNode temp = treeNodes.removeFirst();
                integers.add(temp.val);
                if(temp.left!=null) {
                    treeNodes.add(temp.left);
                }
                if(temp.right!=null) {
                    treeNodes.add(temp.right);
                }
            }
            ans.add(integers);
        }
        return ans;

    }
}
