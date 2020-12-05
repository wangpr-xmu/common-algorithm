package org.worker.hnalgorithm.linkedlist.lrucache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private class LRUCacheNode {
        private int key;
        private int value;
        private LRUCacheNode pre;
        private LRUCacheNode next;
        public LRUCacheNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private int capacity;
    private LRUCacheNode head = new LRUCacheNode(-1, -1);
    private LRUCacheNode tail = new LRUCacheNode(-1, -1);
    private Map<Integer,LRUCacheNode> cacheMap = new HashMap<>();
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if(!cacheMap.containsKey(key)) {
            return -1;
        }
        LRUCacheNode current = cacheMap.get(key);
        current.pre.next = current.next;
        current.next.pre = current.pre;
        insertToTail(current);
        return current.value;
    }

    public void put(int key, int value) {
        if(cacheMap.containsKey(key)) {
            LRUCacheNode cacheNode = cacheMap.get(key);
            cacheNode.value = value;
            get(key);
            return ;
        }

        if(cacheMap.size() == capacity) {
            cacheMap.remove(head.next.key);
            head.next = head.next.next;
            head.next.pre = head.next.pre.pre;
        }

        LRUCacheNode node = new LRUCacheNode(key,value);
        insertToTail(node);
        cacheMap.put(key, node);

    }
    private void insertToTail(LRUCacheNode node) {
        tail.pre.next = node;
        node.pre = tail.pre;
        node.next = tail;
        tail.pre = node;
    }
}
