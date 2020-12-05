package org.worker.hnalgorithm.linkedlist.addtwolist;

/**
 * 链表求和
 */
public class AddTwoListNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(null == l2) {
            return l1;
        }
        ListNode dummy = new ListNode(-1);
        ListNode mNode = dummy;
        int mod = 0;
        while(null != l1 && null != l2) {
            int sum = l1.val + l2.val + mod;
            int val = sum % 10;
            mod = sum / 10;
            ListNode next = new ListNode(val);
            mNode.next = next;
            mNode = mNode.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null) {
            int sum = l1.val + mod;
            int val = sum % 10;
            mod = sum  / 10;
            ListNode next = new ListNode(val);
            mNode.next = next;
            mNode = mNode.next;
            l1 = l1.next;
        }

        while(l2 != null) {
            int sum = l2.val + mod;
            int val = sum % 10;
            mod = sum / 10;
            ListNode next = new ListNode(val);
            mNode.next = next;
            mNode = mNode.next;
            l2 = l2.next;
        }
        if(mod > 0) {
            mNode.next = new ListNode(mod);
        }

        return dummy.next;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}

