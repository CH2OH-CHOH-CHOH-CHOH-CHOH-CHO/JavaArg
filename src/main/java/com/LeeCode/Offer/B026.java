package com.LeeCode.Offer;

public class B026 {
    public static void main(String[] args) {
        new B026().reorderList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
    }
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode now = head;
        slow = slow.next;

        slow = reverseList(slow);

        while(slow!=null){
            ListNode temp1 = now.next;
            ListNode temp2 = slow.next;

            now.next = slow;
            now.next.next = temp1;
            now = temp1;
            slow = temp2;
        }
        if(now!=null)  now.next=null;

    }

    private ListNode reverseList(ListNode head) {
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
