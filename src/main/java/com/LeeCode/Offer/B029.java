package com.LeeCode.Offer;

public class B029 {
    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    };
    public Node insert(Node head, int insertVal) {
        if (head==null){
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }
        Node temp = head;
        while(temp.next!=head){
            if(temp.next.val<temp.val) {
                if(temp.next.val>=insertVal) break;
                else if(temp.val<=insertVal) break;
            }
            if(temp.val<=insertVal && temp.next.val>=insertVal) break;
            temp=temp.next;
        }
        temp.next = new Node(insertVal,temp.next);
        return head;

    }
}
