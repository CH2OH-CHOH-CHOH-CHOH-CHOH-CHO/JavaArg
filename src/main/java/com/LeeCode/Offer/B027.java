package com.LeeCode.Offer;

public class B027 {
    public static void main(String[] args) {
        new B027().isPalindrome(new ListNode(1,new ListNode(2,new ListNode(2,new ListNode(1)))));
    }
    public boolean isPalindrome(ListNode head) {
        if(head==null) return false;
        ListNode last = mid(head).next;
        last = reverse(last);
        while(head!=null){
            if (last==null) return true;
            if(head.val != last.val) return false;
            head=head.next;
            last=last.next;
        }

        return true;
    }

    private ListNode mid(ListNode head){
        ListNode low = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            low = low.next;
            fast = fast.next.next;
        }

        return low;
    }

    private ListNode reverse(ListNode head){
        ListNode cur = head;
        ListNode pre = null;
        while(cur!=null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        return pre;
    }

}
