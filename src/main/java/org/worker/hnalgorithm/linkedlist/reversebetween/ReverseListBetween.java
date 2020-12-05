package org.worker.hnalgorithm.linkedlist.reversebetween;

/**
 * 反转链表II
 */
public class ReverseListBetween {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null) {return head;}
        if(m >= n) {return head;}
        ListNode guard = new ListNode(-1);
        guard.next = head;
        ListNode mPre = null;
        ListNode mNode = head;
        for(int i = 1; i < m; i++) {
            mPre = mNode;
            mNode = mNode.next;
        }
        ListNode cur = mNode.next;
        ListNode pre = mNode;
        for(int i = m; i < n; i++) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        if(mPre != null) {
            mPre.next = pre;
        }else {
            guard.next = pre;
        }
        mNode.next = cur;

        return guard.next;
    }
    public static ListNode reverseBetweenWithDummyNode(ListNode head, int m, int n) {
        if(head.next == null) {return head;}
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        head = dummyNode;
        for(int i = 1; i < m; i++) {
            head = head.next;
        }
        ListNode mPre = head;
        ListNode mNode = head.next;
        ListNode nPre = head.next;
        ListNode nCur = nPre.next;
        for(int i = m; i < n; i++) {
            ListNode tNode = nCur.next;
            nCur.next = nPre;
            nPre = nCur;
            nCur = tNode;
        }
        mNode.next = nCur;
        mPre.next = nPre;

        return dummyNode.next;
    }
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode reverseList = reverseBetweenWithDummyNode(n1, 2,4);
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