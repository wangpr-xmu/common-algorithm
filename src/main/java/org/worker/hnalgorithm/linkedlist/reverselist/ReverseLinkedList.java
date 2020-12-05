package org.worker.hnalgorithm.linkedlist.reverselist;

/**
 * 反转链表
 */
public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;

        while(cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode reverseList = reverseList(n1);
        while(reverseList != null) {
            System.out.println(reverseList.val);
            reverseList = reverseList.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
