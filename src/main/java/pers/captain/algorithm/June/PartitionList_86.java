package pers.captain.algorithm.June;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import pers.captain.algorithm.structrue.ListNode;

/**
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * <p>
 * 你应当保留两个分区中每个节点的初始相对位置。
 * <p>
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 */
public class PartitionList_86 {
    /**
     * preDummyNode 前半部分头
     * preTailNode  前半部分尾
     * <p>
     * dummyNode    后半部分头
     * tailNode     后半部分尾
     * <p>
     * curNode  当前节点
     *
     * @param head
     * @param x
     * @return
     */
    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;

        ListNode curNode = head;

        ListNode preDummyNode = new ListNode(0);
        ListNode preTailNode = preDummyNode;

        ListNode dummyNode = new ListNode(0);
        ListNode tailNode = dummyNode;

        while (curNode != null) {
            if (curNode.val <= x) { //放在后半部分
                preTailNode.next = curNode;
                preTailNode = curNode;
            } else {
                tailNode.next = curNode;
                tailNode = curNode;
            }
            curNode = curNode.next;

//            tailNode.next = null;//解开尾巴
//            preTailNode.next = null;//
        }
        preTailNode.next = dummyNode.next;
        return preDummyNode.next;
    }


    @Test
    public void test() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(5);
        node1.next = node2;
        ListNode node3 = new ListNode(4);
        node2.next = node3;

        ListNode node4 = new ListNode(2);
        node3.next = node4;

        node1 = partition(node1, 3);

        System.out.println(JSON.toJSONString(node1));
    }

    public static ListNode partition1(ListNode head, int x) {
        if (head == null || head.next == null) return head;

        ListNode curNode = head;

        ListNode preDummyNode = new ListNode(0);
        ListNode preTailNode = preDummyNode;

        ListNode dummyNode = new ListNode(0);
        ListNode tailNode = dummyNode;

        while (curNode != null) {
            if (curNode.val < x) { //放在后半部分
                preTailNode.next = curNode;
                preTailNode = curNode;
            } else {
                tailNode.next = curNode;
                tailNode = curNode;
            }
            curNode = curNode.next;

            tailNode.next = null;
            preTailNode.next = null;
        }
        preTailNode.next = dummyNode.next;
        return preDummyNode.next;
    }

    public static ListNode partition2(ListNode head, int x) {
        if (head == null || head.next == null) return head;

        ListNode curNode = head;

        ListNode preDummyNode = new ListNode(0);
        ListNode preTailNode = preDummyNode;


        ListNode dummyNode = new ListNode(0);
        ListNode tailNode = dummyNode;

        while (curNode != null) {
            if (curNode.val < x) { //放在前半部分
                preTailNode.next = curNode;
                preTailNode = preTailNode.next;
            } else {
                tailNode.next = curNode;
                tailNode = tailNode.next;
            }
            curNode = curNode.next;
        }
        tailNode.next = null;
        preTailNode.next = dummyNode.next;
        return preDummyNode.next;
    }


}
