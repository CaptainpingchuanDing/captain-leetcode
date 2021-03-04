package pers.captain.algorithm.offer.five;

import org.junit.Test;
import pers.captain.algorithm.CapL;
import pers.captain.algorithm.structrue.ListNode;

/**
 * 题目描述
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * 示例1
 * 输入
 * <p>
 * {1,2,3,3,4,4,5}
 * 返回值
 * <p>
 * {1,2,5}
 */
public class NO56DeleteDuplication {

    /**
     * 找到 start-end所有重复的元素。
     * pre=dummy  start=head  end = start.next
     * if(start.val == end.val)
     * end = end.next;
     * else
     * pre.next = end;
     * start = pre.next
     *
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication2(ListNode pHead) {
        if (pHead == null || pHead.next == null) return pHead;
        ListNode dummy = new ListNode(0);
        dummy.next = pHead;
        ListNode pre = dummy, start = pre.next, end;
        while (start != null) {
            end = start.next;
            boolean flag = false;
            while (end != null && start.val == end.val) {
                end = end.next;
                flag = true;
            }
            if (flag) {
                pre.next = end;
                start = pre.next;
            } else {
                pre = start;
                start = start.next;
            }
        }
        return dummy.next;
    }

    @Test
    public void deleteDuplication2() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        head.next = node2;
        ListNode node3 = new ListNode(2);
        node2.next = node3;
        ListNode node4 = new ListNode(3);
        node3.next = node4;
        ListNode node5 = new ListNode(3);
        node4.next = node5;
        ListNode res = deleteDuplication2(head);
        CapL.print(res.toString());
    }

    /**
     * 没有认真看题目，只是任务吧重复的数字保留一个就好
     * dummy node
     * pre  cur ,
     * if pre.val == cur.val
     * pre.next = cur.next; cur.next = null; cur = pre.next;
     * if pre.val != cur.val
     * pre = pre.next;  cur = cur.next
     *
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode dummy = new ListNode(0);
        dummy.next = pHead;
        ListNode pre = dummy;
        ListNode cur = pre.next;
        while (cur != null) {
            if (pre == dummy) {
                pre = pre.next;
                cur = pre.next;
            } else {
                if (cur.val == pre.val) {
                    pre.next = cur.next;
                    cur.next = null;
                    cur = pre.next;
                } else {
                    pre = pre.next;
                    cur = pre.next;
                }
            }
        }
        return dummy.next;
    }
}
