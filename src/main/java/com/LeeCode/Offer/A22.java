package com.LeeCode.Offer;

public class A22 {
      public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode getKthFromEnd(ListNode head, int k) {
          ListNode temp = head;
          int nums = 0;
        while(temp!=null){
            temp = temp.next;
            nums ++;
        }
        temp = head;
        for(int i = 0;i<nums-k;i++){
            temp = temp.next;
        }
        return temp;
    }
}
