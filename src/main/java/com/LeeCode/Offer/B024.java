package com.LeeCode.Offer;

public class B024 {
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        ListNode pre = null;
        ListNode now = head;

        while(now!=null){
            ListNode temp = now.next;
            now.next=pre;
            pre= now;
            now=temp;
        }

        return pre;
    }
}
