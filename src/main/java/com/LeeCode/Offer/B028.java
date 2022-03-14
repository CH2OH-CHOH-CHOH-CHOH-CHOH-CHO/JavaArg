package com.LeeCode.Offer;

public class B028 {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }



    public Node flatten(Node head) {
        Node now = head;
        while (now != null) {
            if (now.child != null) {
                Node temp = now.next;
                now.next = flatten(now.child);
                now.child = null;
                now.next.prev = now;
                while (now.next != null) {
                    now = now.next;
                }
                now.next = temp;
                if(temp != null)temp.prev = now;

            } else {
                now = now.next;
            }

        }

        return head;
    }
}
