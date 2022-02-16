package com.LeeCode.Medium;

public class Medium2 {
    public static void main(String[] args) {
        ListNode l1=new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9)))))));
        ListNode l2=new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9))));

        l1.show();
        l2.show();

        ListNode l3=Medium2.addTwoNumbers(l1,l2,0);
        l3.show();
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public void show(){
            ListNode listNode =this;
            while(listNode!=null) {
                System.out.print(listNode.val);
                listNode=listNode.next;
            }
            System.out.println();
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2,int ret) {

        int mod=(l1.val+l2.val+ret)%10;
        int retNext=(l1.val+l2.val+ret)/10;

        if(l1.next==null && l2.next==null){
            if(retNext==1) return new ListNode(mod,new ListNode(1));
            else return new ListNode(mod);
        }
        else if(l1.next==null) return new ListNode(mod,Medium2.addTwoNumbers(new ListNode(0),l2.next,retNext));
        else if(l2.next==null) return new ListNode(mod,Medium2.addTwoNumbers(l1.next,new ListNode(0),retNext));
        else return new ListNode(mod,Medium2.addTwoNumbers(l1.next,l2.next,retNext));
    }

}

/*
*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return Solution.addTwoNumbers(l1,l2,0);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2,int ret) {

        int mod=(l1.val+l2.val+ret)%10;
        int retNext=(l1.val+l2.val+ret)/10;

        if(l1.next==null && l2.next==null){
            if(retNext==1) return new ListNode(mod,new ListNode(1));
            else return new ListNode(mod);
        }
        else if(l1.next==null) return new ListNode(mod,Solution.addTwoNumbers(new ListNode(0),l2.next,retNext));
        else if(l2.next==null) return new ListNode(mod,Solution.addTwoNumbers(l1.next,new ListNode(0),retNext));
        else return new ListNode(mod,Solution.addTwoNumbers(l1.next,l2.next,retNext));
    }
}*/
