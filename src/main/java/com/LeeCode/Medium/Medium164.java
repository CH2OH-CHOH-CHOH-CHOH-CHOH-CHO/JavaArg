package com.LeeCode.Medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
        实现 LRUCache 类：
        LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
        int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
        void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
        函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。

         

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/lru-cache
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class Medium164 {
    private int size;
    private int capacity;
    private DLinkedNode head;
    private DLinkedNode tail;
    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();

    class DLinkedNode {
        int key;
        int value;
        private DLinkedNode prev;
        private DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public DLinkedNode(int key, int value, DLinkedNode prev, DLinkedNode next) {
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    public Medium164(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;

    }

    public int get(int key) {
        DLinkedNode dLinkedNode= cache.get(key);
        if(dLinkedNode==null) return -1;
        else {
            this.moveToHead(dLinkedNode);
            return dLinkedNode.value;

        }
    }

    public void put(int key, int value) {
        DLinkedNode dLinkedNode= cache.get(key);
        if(dLinkedNode != null){
            dLinkedNode.value = value;
            moveToHead(dLinkedNode);
        }
        else {
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                // 如果超出容量，删除双向链表的尾部节点
                DLinkedNode tail = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                --size;
            }

        }

    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}

