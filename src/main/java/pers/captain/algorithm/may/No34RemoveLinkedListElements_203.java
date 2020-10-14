package pers.captain.algorithm.may;

import pers.captain.algorithm.structrue.ListNode;

/**
 * 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class No34RemoveLinkedListElements_203 {
    /*
    重新建立一个新的链表,
     */
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode fake = new ListNode(0);
        ListNode newPosition = null;
        ListNode temp = head;
        while (temp != null) {
            if (temp.val != val) {
                if (fake.next == null) {
                    fake.next = temp;
                } else {
                    newPosition.next = temp;
                }
                newPosition = temp;
            }
            temp = temp.next;
        }
        if (newPosition != null) {
            newPosition.next = null;
        }
        return fake.next;
    }


    /*
    原来的链表的基础上进行修改
     */
    public static ListNode removeElements2(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode fake = new ListNode(0);
        ListNode newPosition = null;
        ListNode temp = head;
        while (temp != null) {
            if (temp.val != val) {
                if (fake.next == null) {
                    fake.next = temp;
                    newPosition = temp;
                } else {
                    newPosition.next = temp;
                }
            }
            temp = temp.next;
        }

        return fake.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(6);
        node2.next = node3;

        ListNode node4 = new ListNode(3);
        node3.next = node4;

        ListNode node5 = new ListNode(4);
        node4.next = node5;

        ListNode node6 = new ListNode(5);
        node5.next = node6;

        ListNode node7 = new ListNode(6);
        node6.next = node7;

        System.out.println(node1);

        System.out.println(No34RemoveLinkedListElements_203.removeElements(node1, 6));

    }
}
