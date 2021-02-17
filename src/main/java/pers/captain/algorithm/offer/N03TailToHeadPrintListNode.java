package pers.captain.algorithm.offer;

import org.junit.Assert;
import org.junit.Test;
import pers.captain.algorithm.CapL;
import pers.captain.algorithm.structrue.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * 示例1
 * 输入
 * <p>
 * {67,0,24,58}
 * 返回值
 * <p>
 * [58,24,0,67]
 */
public class N03TailToHeadPrintListNode {
    /**
     * 方法一  利用栈先进后出的性质
     * time O(n)  space O(n)
     *
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (listNode == null) return list;
        Stack<Integer> stack = new Stack<>();
        ListNode head = listNode;
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

    @Test
    public void printListFromTailToHead() {
        ArrayList<Integer> list = printListFromTailToHead1(ListNode.getExample());
        CapL.print(list);
    }

    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (listNode == null) return list;
        ListNode head = listNode;
        ListNode cur = listNode.next;
        ListNode pre = null;
        head.next = pre;
        while (cur != null) {
            pre = head;
            head = cur;
            cur = cur.next;
            head.next = pre;
        }
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list;
    }
    @Test
    public void printListFromTailToHead2() {
        ArrayList<Integer> list = printListFromTailToHead2(ListNode.getExample());
        CapL.print(list);
    }
}
