package com.LeeCode.Offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class A32_3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        if(root==null) return ans;

        treeNodes.add(root);

        while(treeNodes.size()!=0){
            LinkedList<Integer> integers = new LinkedList<>();
            int len = treeNodes.size();
            for(int i = 0;i<len;i++){
                TreeNode temp;
                temp = treeNodes.poll();
                if(ans.size()%2==0){
                    integers.addLast(temp.val);
                }
                else {
                    integers.addFirst(temp.val);
                }
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
