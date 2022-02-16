package com.LeeCode.Offer;

public class A35 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    public Node copyRandomList(Node head) {
        if(head==null) return null;

        for(Node node = head; node!=null;node = node.next.next){
            Node newNode = new Node(node.val);
            newNode.next = node.next;
            node.next = newNode;
        }

        for(Node node = head; node!=null;node = node.next.next) {
            Node temp = node.next;
            temp.random = (node.random != null) ? node.random.next : null;

        }

        Node headNew = head.next;
        for(Node node = head; node!=null;node = node.next) {
            Node temp =node.next;
            node.next = node.next.next;
            temp.next =  (temp.next != null)?temp.next.next:null;
        }
         return    headNew;
    }
}}
