package com.LeeCode.Offer;

import javax.security.auth.login.CredentialException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class A37 {
    public static void main(String[] args) {
        new A37().deserialize(new String("1,2,3,null,null,4,5"));
    }
    StringBuilder stringBuilder  = new StringBuilder();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) {
            stringBuilder.append("null");
        }
        else {
            stringBuilder.append(root.val);
            dfs(root.left);
            dfs(root.right);
        }
        return stringBuilder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        LinkedList<String> dataList = new LinkedList<String>(Arrays.asList(dataArray));

        return rdeserialize(dataList);
    }

    private void dfs(TreeNode root){
        if(root==null){
            stringBuilder.append(",null");
            return;
        }
        stringBuilder.append(","+root.val);
        dfs(root.left);
        dfs(root.right);
    }

    private TreeNode rdeserialize(LinkedList<String> dataList) {
        TreeNode node ;
        if(dataList.get(0).equals("null")){
            dataList.removeFirst();
            return null;
        }
        else{
            node = new TreeNode(Integer.valueOf(dataList.get(0)));
            dataList.removeFirst();
        }
        node.left=rdeserialize(dataList);
        node.right=rdeserialize(dataList);
        return node;
    }
}
