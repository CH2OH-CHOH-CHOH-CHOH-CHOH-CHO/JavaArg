package com.DataStructure;

public class DoubleLinkedList<AnyType> {
    private Node head = new Node();

    private class Node<AnyType> {
        private Node next = null;
        private Node pre = null;
        private AnyType element = null;
    }

    public DoubleLinkedList() {

    }

    public int size(){
        Node p = head;
        int size = 0;
        while(p.next != null){
            p = p.next;
            size ++;
        }
        return size;
    }


    public void add(AnyType x) throws Exception {
        insert(size(),x);
    }

    public void insert(int idx, AnyType x) throws Exception {
        if(idx < 0 || idx >size()) throw new Exception();
        Node p = head;
        for (int i = 0; i < idx; i++) {
            p = p.next;
        }
        Node t = new Node();
        t.element = x;

        t.pre = p;
        t.next =p.next;
        if(p.next != null) {
            p.next.pre = t;
        }
        p.next = t;

    }

    public void delete() throws Exception {
        if(size() == 0) throw new Exception();
        delete(size()-1);
    }

    public void delete(int idx) throws Exception {
        if(idx < 0 || idx >=size()) throw new Exception();
        Node p = head;
        for (int i = 0; i < idx; i++) {
            p = p.next;
        }
        if(idx != size() -1) p.next = p.next.next;
        else p.next = null;
    }

    public void show(){
        Node p = head;
        for(int i = 0; i<size(); i++){
            p = p.next;
            System.out.println(p.element);
        }
    }


    public static void main(String[] args) throws Exception {
        DoubleLinkedList<Integer> cll = new DoubleLinkedList();
        cll.add(1);
        cll.add(3);
        cll.add(2);
        cll.add(6);
        cll.add(8);
        cll.add(0);


        cll.delete(5);
        cll.add(7);

        System.out.println("a" + cll.size());

        cll.show();
    }
}
