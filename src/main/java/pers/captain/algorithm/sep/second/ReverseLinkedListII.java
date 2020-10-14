package pers.captain.algorithm.sep.second;

import org.junit.Assert;
import org.junit.Test;
import pers.captain.algorithm.structrue.ListNode;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseLinkedListII {


    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m >= n || n <= 0 || m <= 0) return head;

        return null;
    }

    public static ListNode reverseBetween2(ListNode head, int m, int n) {
        if (m >= n || n <= 0 || m <= 0) return head;
        ListNode cur = head;
        int restStep = n - m + 1;
        while (m > 2) {
            m--;
            cur = cur.next;
        }

        //翻转区间 m-n
        ListNode rest = cur.next;
        ListNode restHead = null;
        ListNode restTail = null;
        while (restStep > 0 || rest != null) {
            if (restStep == 0) {
                // n 到结尾 的链表补充上
                restTail.next = rest;
                break;
            }
            if (restHead == null) {
                restHead = rest;
                restTail = restHead;
                rest = rest.next;
            } else {
                ListNode temp = rest;
                rest = rest.next;
                temp.next = restHead;
                restHead = temp;
            }
            restStep--;

        }

        cur.next = restHead;
        return head;
    }


    public static ListNode reverseBetween1(ListNode head, int m, int n) {
        if (m >= n || n <= 0 || m <= 0) return head;
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        ListNode cur = head;
        dummy.next = head;
        // find m
        int count = 0;
        while (cur != null && count < m - 1) {
            pre = pre.next;
            cur = cur.next;
            count++;
        }
        if (cur == null) return head;
        // 拔插 m=2 n=3
        // 1(pre) ->3->2(cur)-> 4
        count = 0;
        while (count < n - m  && cur.next != null) {
            ListNode removed = cur.next; // 1(pre) ->2(cur)-> 3-> 4   temp = 3->4
            cur.next = cur.next.next;// 1(pre) ->2(cur)-> 4   temp = 3->4

            removed.next = pre.next; // 1(pre) ->2(cur)-> 4   temp = 3->2
            pre.next = removed; // 1(pre) ->3 (temp)->2(cur)-> 4
            count++;
        }

        return dummy.next;
    }

    @Test
    public void reverseBetween1(){
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        head.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;
        ListNode result = reverseBetween1(head,2,4);
        System.out.println(result.toString());

        Assert.assertEquals("1-->4-->3-->2-->5",result.toString());

    }


    public static ListNode reverseBetweenTest(ListNode head, int m, int n) {
        if (m >= n || n <= 0 || m <= 0) return head;
        ListNode dummy = new ListNode(0);

        return dummy.next;
    }
}
