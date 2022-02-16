package com.DataStructure;

public class LeftistHeap {
    private Node root=null;

    class Node{
        private int element;
        private int npl;
        private Node leftChild;
        private Node rightChild;

        public Node(int element, int npl, Node leftChild, Node rightChild) {
            this.element = element;
            this.npl = npl;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }

    public LeftistHeap() {

    }

    public void add(int x){
        Node newNode = new Node(x,0,null,null);
        if(root!=null) merge(root,newNode);
        else root = newNode;
    }
    public Node merge(Node h1, Node h2){
        if(h1==null) return h2;
        if(h2==null) return h1;
        if(h1.element < h2.element) return merge1(h1,h2);
        else return merge1(h2,h1);

    }

    private Node merge1(Node h1,Node h2) {
        if(h1.leftChild==null) h1.leftChild = h2;
        else {
            merge(h1.rightChild,h2);
            if(h1.leftChild.npl < h1.rightChild.npl){
                Node temp = h1.leftChild;
                h1.leftChild = h1.rightChild;
                h1.rightChild = temp;
                h1.npl = h1.rightChild.npl+1;
            }
        }

        return h1;
    }

    public void showFirst(){
        showFirst(root,0);
    }

    public void showFirst(Node node,int depth){
        this.displaySpace(depth);
        System.out.print(node.element);
        if(node.leftChild!=null) showFirst(node.leftChild,depth+1);
        if(node.rightChild!=null) showFirst(node.rightChild,depth+1);
    }

    private void displaySpace(int depth){
        while(depth-->0) System.out.print("  ");
    }

    public static void main(String[] args) {
        LeftistHeap lh = new LeftistHeap();
        lh.add(1);
        lh.add(2);
        lh.add(8);
        lh.add(4);
        lh.add(9);
        lh.add(3);
        lh.add(7);
        lh.showFirst();

    }
}
