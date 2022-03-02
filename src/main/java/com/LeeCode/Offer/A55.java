package com.LeeCode.Offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class A55 {
    public int maxDepth(TreeNode root) {

        int depth = 0;
        if(root==null) return depth;

        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);

        while(treeNodes.size()!=0){
            ArrayList<Integer> integers = new ArrayList<>();
            for(int i = treeNodes.size();i>0;i--){
                TreeNode temp = treeNodes.removeFirst();
                integers.add(temp.val);
                if(temp.left!=null) {
                    treeNodes.add(temp.left);
                }
                if(temp.right!=null) {
                    treeNodes.add(temp.right);
                }
            }
            depth++;
         }
        return depth;
    }
}
