package com.DataStructure;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CircleLinkedList<AnyType> {
    private Node first = new Node();
    private int size = 0;

    private class Node<AnyType> {
        private AnyType element = null;
        private Node next = null;

        Node() {
            this(null, null);
        }

        Node(AnyType x, Node p) {
            this.element = x;
            this.next = p;
        }
    }

    public void add(AnyType x) {
        if (size == 0) {
            first.next = first;
            first.element = x;
        } else {
            Node<AnyType> p = first;
            while (p.next != first) p = p.next;
            Node<AnyType> t = new Node(x, first);
            p.next = t;

        }
        size++;
    }

    public void delete() {
        if (size == 1) {
            first.next = null;
            first.element = null;
        }
        else {
            Node<AnyType> p = first;
            Node<AnyType> t = new Node<>();
            while (p.next != first) {
                t = p;
                p = p.next;
            }
            t.next = first ;

        }

        size--;
    }

    public void show(){
        Node<AnyType> p = first;
        while (p.next != first){
            System.out.println(p.element);
            p = p.next;
        }
        System.out.println(p.element);
    }

    public int getSize() {
        return size;
    }


    public int ringOut(int m){
        if(m<1){
            System.out.println("error");
            return 1;
        }
        Node p = first;
        Node t = first;
        while(t.next != first) {
            t = t.next;
        }

        while(p.next != t){
            for (int i = 0; i < m-1; i++) {
                p=p.next;
                t=t.next;
            }
            System.out.println(p.element);
            t.next=p.next;
            p=p.next;
        }
        if(m%2==0){
            System.out.println(t.element);
            System.out.println(p.element);
        }
        else{
            System.out.println(p.element);
            System.out.println(t.element);
        }
        return 0;
    }
    @Test
    public void ringout2(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 41; i++) {
            list.add(i+1);
        }
        int r = 0;
        int m = 4;
        for(int i =2; i<=41; i++){
            r = (r+m)%i;
        }
        System.out.println(r+1);
    }
    public static void main(String[] args) {
        CircleLinkedList<Integer> cll = new CircleLinkedList();
        for(int i =1; i <=41; i++) cll.add(i);

        cll.ringOut(4);

    }
}
