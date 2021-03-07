package pers.captain.algorithm.offer.five;

import org.junit.Assert;
import org.junit.Test;
import pers.captain.algorithm.structrue.ListNode;

/**
 * 题目描述
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null
 */
public class NO55EntryNodeOfLoop {
    /**
     * 方法一： 快慢指针
     *
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) return null;
        ListNode p1 = pHead;
        ListNode p2 = pHead;
        if (p1.next != null) p1 = p1.next;
        else return null;
        while (p1 != p2) {
            if (p2 == null || p1 == null || p1.next == null) return null;
            p2 = p2.next;
            p1 = p1.next.next;
            if (p1 == p2) {
                p1 = pHead;
                while (p1 != p2) {
                    p1 = p1.next;
                    p2 = p2.next;
                }
                return p1;
            }
        }
        return p1;
    }

    public ListNode EntryNodeOfLoop2(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode fast = pHead;
        ListNode slow = pHead;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode slow2 = pHead;
                while (slow2 != slow) {
                    slow2 = slow2.next;
                    slow = slow.next;
                }
                return slow2;
            }
        }
        return null;
    }
    // a b c
    // fast  a + b + (b+c)
    //

    @Test
    public void EntryNodeOfLoop() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        head.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;
        node5.next = node2;
        ListNode result = EntryNodeOfLoop(head);
        Assert.assertEquals(result, node2);
    }
}
