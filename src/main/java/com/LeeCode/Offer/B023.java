package com.LeeCode.Offer;

public class B023 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode fast = headA;
        ListNode slow = headB;
        while(fast!=slow){
            if(fast.next==null && slow.next==null) return null;
            if(fast.next==null) fast = headB;
            else fast= fast.next;
            if(slow.next==null) slow = headA;
            else slow= slow.next;
        }

        return fast;
    }
}
