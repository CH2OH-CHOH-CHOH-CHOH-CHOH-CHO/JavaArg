package com.LeeCode.Offer;

public class B024 {
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        ListNode pre = new ListNode(-1);
        ListNode now = head;

        while(now.next!=null){
            ListNode temp = now.next;
            now.next=null;
            pre.next = now;
            pre = pre.next;
            now=temp;
        }

        return pre;
    }
}
