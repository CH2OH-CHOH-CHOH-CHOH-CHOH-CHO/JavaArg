package com.LeeCode.Offer;


import java.util.LinkedList;

class B025 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = 0;
        int len2 = 0;
        LinkedList<Integer>  listNodes = new LinkedList<>();
        ListNode tempL1 = l1;
        ListNode tempL2 = l2;
        //计数链表长度
        while(tempL1!=null){
            len1++;
            tempL1=tempL1.next;
        }
        while(tempL2!=null){
            len2++;
            tempL2=tempL2.next;
        }

        //判断哪个链表更长，选取长的作为名义上的l1
        if(len2>len1){
            tempL1 = l2;
            tempL2 = l1;
            int temp =len1;
            len1 = len2;
            len2 = temp;
        }
        else {
            tempL1 = l1;
            tempL2 = l2;
        }

        //存入栈中
        while (len1>len2){
            len1--;
            listNodes.add(tempL1.val);
            tempL1=tempL1.next;
        }
        while(tempL1!=null && tempL2!=null){
            listNodes.add(tempL1.val+ tempL2.val);
            tempL1=tempL1.next;
            tempL2=tempL2.next;
        }

        ListNode ans = null;
        int c =  0;
        while(listNodes.peek()!=null){
            int  x = listNodes.poll();
            c = (x+c)>9? 1:0;
            x = (x+c)%10;
            ans = new ListNode(x,ans);
        }
        //栈空仍有进位数据
        if(c!=0) ans = new ListNode(c,ans);
        return ans;
    }
}