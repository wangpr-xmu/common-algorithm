package org.worker.hnalgorithm.linkedlist.eepcopylistwithrandompointer;

import java.util.HashMap;
import java.util.Map;

/**
 * 复制带随机指针的链表
 */
public class DeepCopyRandomList {
    public Node copyRandomList(Node head) {
        if(null == head) {
            return head;
        }

        Node newHead = head;
        while(newHead != null) {
            Node copyHead = new Node(newHead.val);
            copyHead.next = newHead.next;
            newHead.next = copyHead;
            newHead = copyHead.next;
        }
        newHead = head;
        while(null != newHead && null != newHead.next) {
            if(null != newHead.random) {
                newHead.next.random = newHead.random.next;
            }
            newHead = newHead.next.next;
        }
        newHead = head;
        Node result = head.next;
        while(newHead != null && null != newHead.next) {
            Node n1 = newHead.next;
            if(null == n1.next) {
                newHead.next = null;
            }else {
                newHead.next = n1.next;
                n1.next = newHead.next.next;
                newHead = newHead.next;
            }
        }

        return result;
    }
    public Node solution1(Node head) {
        if(null == head) {
            return head;
        }
        Node newHead = head;
        Map<Node, Node> map = new HashMap<>();

        while(newHead != null) {
            if(!map.containsKey(newHead)) {
                Node copyHead = new Node(newHead.val);
                map.put(newHead, copyHead);
            }
            if(null != newHead.random) {
                if(!map.containsKey(newHead.random)) {
                    Node copyRandom = new Node(newHead.random.val);
                    map.put(newHead.random, copyRandom);
                }
                map.get(newHead).random = map.get(newHead.random);
            }
            newHead = newHead.next;
        }
        newHead = head;
        while(null != newHead) {
            Node copyHead = map.get(newHead);
            Node copyHeadNext = map.get(newHead.next);
            copyHead.next = copyHeadNext;
            newHead = newHead.next;
        }

        return map.get(head);
    }

    public static void main(String[] args) {

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n1.next = n2;
        n1.random = n3;
        n2.next = n3;
        n2.random = n1;
        n3.next = n4;
        n4.random = n3;

        DeepCopyRandomList copyRandomList = new DeepCopyRandomList();

        Node cpHead = copyRandomList.copyRandomList(n1);

        while(null != cpHead) {
            if(null != cpHead.random) {
                System.out.println("val: " + cpHead.val + ", random: " + cpHead.random.val);
            }else {
                System.out.println("val: " + cpHead.val + ", random: " + cpHead.random);
            }
            cpHead = cpHead.next;
        }

    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
