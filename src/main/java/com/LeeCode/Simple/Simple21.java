package com.LeeCode.Simple;

public class Simple21 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp = list1;
        //保证list1总是头指针值最小的一个
        if(list1==null) return list2;
        if(list2==null) return list1;

        if(list1.val<=list2.val) ;
        else {
            list1 = list2;
            list2 = temp;
        }
        ListNode head = list1;
        ListNode before  = null;

        //如果list2的值小于list1，那么插入到他刚好前面一个空，否则list1递增
        while(list1!=null && list2 != null){
            if(list2.val<list1.val){
                temp=list2.next;

                //将list2的当前值插入list1当前值之前
                before.next=list2;
                list2.next=list1;
                before = list2;
                list2 = temp;
            }
            else {
                before=list1;
                list1=list1.next;
            }
        }

        //如果遍历完list1都发现list2还有值大于list1最大的数，那么就插入到list1最末尾
        if(list2!=null){
            before.next=list2;
        }
        return head;
    }
}
