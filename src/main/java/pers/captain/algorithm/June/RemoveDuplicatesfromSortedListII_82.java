package pers.captain.algorithm.June;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import pers.captain.algorithm.structrue.ListNode;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * <p>
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 */
public class RemoveDuplicatesfromSortedListII_82 {

    /**
     * realNode
     * preNode
     * curNode
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        // 结果的头结点的前一个节点
        ListNode dummy = new ListNode(0);
        //结果的尾节点
        ListNode realNode = dummy;
        // 当前节点的前一个节点
        ListNode preNode = dummy;
        // 遍历现有节点的当前节点
        ListNode curNode = head;

        while (curNode != null) {
            if ((curNode.val != preNode.val || preNode == dummy) && (curNode.next == null || curNode.val != curNode.next.val)) {
                realNode.next = curNode;
                realNode = curNode;
            }
            preNode = curNode;
            curNode = curNode.next;
            preNode.next = null;
        }
        return dummy.next;

    }

    @Test
    public void test() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(2);
        node2.next = node3;

        ListNode node4 = new ListNode(3);
        node3.next = node4;

        node1 = deleteDuplicates(node1);

        System.out.println(JSON.toJSONString(node1));
    }
}
