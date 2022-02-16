package com.LeeCode.Offer;

import java.util.ArrayList;

public class A06 {
      public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public int[] reversePrint(ListNode head) {
        if(head==null) return new int[]{};
        ListNode temp1 = head;
        int i = 0;
          while (head.next!=null){
//              arr[i++]=head.val;
              i++;
              head = head.next;
          }
        int[] arr = new int[i];
          i = 0;
          head = temp1;
        while (head.next!=null){
              arr[i++]=head.val;
            head = head.next;
        }
         int len = arr.length;
          for(i = 0;i<len/2;i++){
              int temp = arr[i];
              arr[i] = arr[len-1-i];
              arr[len-i] = temp;

          }
          return arr;
    }
}
