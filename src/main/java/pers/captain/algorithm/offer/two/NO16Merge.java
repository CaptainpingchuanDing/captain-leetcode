package pers.captain.algorithm.offer.two;

import pers.captain.algorithm.structrue.ListNode;

public class NO16Merge {

    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (list1 != null || list2 != null) {
            if (list1 != null && list2 != null) {
                if (list1.val > list2.val) {
                    cur.next = new ListNode(list2.val);
                    list2 = list2.next;
                } else {
                    cur.next = new ListNode(list1.val);
                    list1 = list1.next;
                }
            } else if (list1 != null) {
                cur.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                cur.next = new ListNode(list2.val);
                list2 = list2.next;

            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
