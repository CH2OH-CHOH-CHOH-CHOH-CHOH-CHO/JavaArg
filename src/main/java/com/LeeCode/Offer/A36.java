package com.LeeCode.Offer;

public class A36 {
    Node pre=new Node(), head=new Node();
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        dfs(root);
        pre.right = head;
        head.left =pre;
        return head;
    }

    private void dfs(Node node){
        if(node==null) return;

        dfs(node.left);

        if(pre==null) head = node;
        else pre.right=node;

        node.left=pre;

        pre = node;


        dfs(node.right);
    }
}
