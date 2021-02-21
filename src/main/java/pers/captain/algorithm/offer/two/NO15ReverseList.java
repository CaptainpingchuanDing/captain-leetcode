package pers.captain.algorithm.offer.two;

import pers.captain.algorithm.structrue.ListNode;

public class NO15ReverseList {

    public ListNode ReverseList(ListNode head) {
        if (head == null) return null;
        ListNode cur = head;
        ListNode nHead = null;
        while (cur != null) {
            ListNode pre = nHead;
            nHead = cur;
            cur = cur.next;
            nHead.next = pre;
        }
        return nHead;
    }
}
