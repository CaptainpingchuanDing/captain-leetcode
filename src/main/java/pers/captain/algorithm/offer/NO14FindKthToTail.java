package pers.captain.algorithm.offer;

import org.junit.Test;
import pers.captain.algorithm.CapL;
import pers.captain.algorithm.structrue.ListNode;

/**
 * 题目描述
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 示例1
 * 输入
 * <p>
 * 1,{1,2,3,4,5}
 * 返回值
 * <p>
 * {5}
 */
public class NO14FindKthToTail {
    /**
     *
     * 双指针找到倒数第k个节点，但是注意k值可能大于链表的长度
     */

    /**
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head, int k) {
        if (k <= 0) return null;
        int len = 0;
        ListNode p1 = head;
        while (p1 != null) {
            len++;
            p1 = p1.next;
        }
        if (len < k) return null;// k大于链表的长度
        p1 = head;
        int i = 1;
        while (p1 != null && i < k) {// p1 先走k步
            p1 = p1.next;
            i++;
        }
        ListNode p2 = head;
        while (p1.next != null) {// p1、p2 同时走
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    public ListNode FindKthToTail2(ListNode head, int k) {
        // todo
        if (k <= 0) return null;
        ListNode p1 = head;
        int i = 1;
        while (i < k) {// p1 先走k步
            if (p1.next == null) return null;//  k大于链表的长度
            p1 = p1.next;
            i++;
        }
        ListNode p2 = head;
        while (p1.next != null) {// p1、p2 同时走
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    @Test
    public void FindKthToTail() {
        ListNode res = FindKthToTail2(ListNode.getExample(), 2);
        CapL.print(res.val);
    }
}
