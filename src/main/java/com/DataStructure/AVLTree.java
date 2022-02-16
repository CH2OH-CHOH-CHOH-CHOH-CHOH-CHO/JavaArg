package com.DataStructure;

import java.util.Map;

public class AVLTree {
    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        avlTree.insert(6);
        avlTree.insert(2);
        avlTree.insert(7);
        avlTree.insert(1);
        avlTree.insert(4);
        avlTree.midOrder();
        System.out.println();
        System.out.println(avlTree.root);
        avlTree.insert(3);
        avlTree.midOrder();
        System.out.println(avlTree.root);
    }
    private class Node{
        int element;
        Node left;
        Node right;
        int height;

        public Node() {
            left =null;
            right=null;
            height = 0;
        }

        public Node(int element) {
            this.element = element;
        }

        public Node(int element, Node left, Node right, int height) {
            this.element = element;
            this.left = left;
            this.right = right;
            this.height = height;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "element=" + element +
                    ", height=" + height +
                    '}';
        }
    }

    private Node root;

    private  void insert(int x){
        root=insert(x,root);
    }

    private Node insert(int x,Node t){
        if(t==null) return new Node(x);
        if(x<t.element) t.left=insert(x,t.left);
        else if(x>t.element) t.right=insert(x,t.right);
        else ;
        return balance(t);
    }

    private Node balance(Node t) {
        if(t==null) return null;
        if(height(t.left)>height(t.right)+1){
            if(height(t.left.left)>=height(t.left.right)){
                t=rotateWithLeft(t);
            }
            else t=doubleWithLeft(t);
        }
        if(height(t.right)>height(t.left)+1){
            if(height(t.right.right)>=height(t.right.left)){
                t=rotateWithRight(t);
            }
            else t=doubleWithRight(t);
        }

        t.height = Math.max(height(t.left),height(t.right))+1;
        return t;
    }

    private Node rotateWithLeft(Node t){
        Node temp =t.left;
        t.left = temp.right;
        temp.right = t;
        t.height = Math.max(height(t.left),height(t.right))+1;
        temp.height = Math.max(height(temp.left),t.height)+1;

        return temp;
    }

    private Node rotateWithRight(Node t){
        Node temp =t.right;
        t.right = temp.left;
        temp.left = t;
        t.height = Math.max(height(t.left),height(t.right))+1;
        temp.height = Math.max(height(temp.right),t.height)+1;

        return temp;
    }

    private Node doubleWithLeft(Node t){
        t.left = rotateWithRight(t.left);
        return rotateWithLeft(t);
    }

    private Node doubleWithRight(Node t){
        t.right = rotateWithLeft(t.right);
        return rotateWithRight(t);
    }

    private int height(Node t){
        return t==null ? -1:t.height;
    }

    public void midOrder(){
        midOrder(this.root);
    }

    public void midOrder(Node t){
        if(t.left!=null) midOrder(t.left);
        if(t!=null) System.out.print(t.element+" ");
        if(t.right!=null) midOrder(t.right);
    }
}
