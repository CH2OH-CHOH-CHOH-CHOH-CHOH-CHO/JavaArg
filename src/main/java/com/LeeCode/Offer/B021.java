package com.LeeCode.Offer;

public class B021 {
    public static void main(String[] args) {
        new B021().removeNthFromEnd(new ListNode(1),1);
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode virtualHead = new ListNode(-1, head);
        ListNode fast = head;
        ListNode low = head;
        while(fast.next!=null && n-->0){
            fast= fast.next;
        }
        while(fast.next!=null){
            fast=fast.next;
            low=low.next;
        }
        low.next=low.next.next;

        return virtualHead.next;
    }
}
