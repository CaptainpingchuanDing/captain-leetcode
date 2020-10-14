package pers.captain.algorithm.sep.second;

import org.junit.Test;
import pers.captain.algorithm.structrue.ListNode;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 *  
 *
 * 示例：
 *
 * 给你这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 *  
 *
 * 说明：
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseNodesinkGroup {

    public ListNode reverseKGroup(ListNode head, int k) {

        if (k <= 1) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode nextPre;
        ListNode cur = head;
        ListNode scan = head;
        int count = 0;
        while (scan != null) {
            count++;
            if (count == k) {// find one group
                count = 0;
                // dummy(pre)->1(cur)->2->3(scan)->4->5
                //the head of the rest
                ListNode nextGroup = scan.next;
                // cut tail of the group
                scan.next = null;
               // pre.next = null;
                nextPre = cur;
                // reverser one group
                ListNode reversedGroup = reverse(cur);
                // pre connect reversed
                pre.next = reversedGroup;
                // reversed connect rest
                nextPre.next = nextGroup;

                // update scan and cur and pre
                scan = nextGroup;
                cur = scan;
                pre = nextPre;

            } else {
                scan = scan.next;
            }
        }

        return dummy.next;

    }

    private static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode pre = null;
        ListNode cur = head;


        while (cur != null) {
            ListNode temp = cur;
            cur = cur.next;
            temp.next = pre;
            pre = temp;
        }
        return pre;
    }

    @Test
    public void reverse(){
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        head.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;

        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;

//        ListNode result = reverseKGroup(head,3);
        ListNode result = reverseKGroupTest(head,3);
        System.out.println(result.toString());
    }

    public static ListNode reverseKGroupTest(ListNode head, int k) {

        if (k <= 1) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode end = head;
        int count = 0;

        while (end != null) {
            count++;
            if (count == k) {
                ListNode nextGroupHead = end.next;
                end.next = null;
                ListNode reversed = reverse(pre.next);
                pre.next = reversed;
                cur.next = nextGroupHead;

                pre = cur;
                cur = cur.next;
                end = cur;
                count = 0;
            } else {
                end = end.next;
            }
        }
        return dummy.next;

    }
}
