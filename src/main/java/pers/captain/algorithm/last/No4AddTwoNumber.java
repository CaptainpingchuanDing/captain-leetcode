package pers.captain.algorithm.last;

import org.junit.Test;
import pers.captain.algorithm.structrue.ListNode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class No4AddTwoNumber {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode result = null;
        ListNode resultTail = null;
        int carry = 0;
        while (head1 != null || head2 != null || carry != 0) {

            int sum = carry + (head1 == null ? 0 : head1.val) + (head2 == null ? 0 : head2.val);
            carry = sum / 10;
            if (result == null) {
                result = new ListNode(sum % 10);
                resultTail = result;
            } else {
                resultTail.next = new ListNode(sum % 10);
                resultTail = resultTail.next;
            }
            if (head1 != null) head1 = head1.next;
            if (head2 != null) head2 = head2.next;
        }

        return result;
    }

    @Test
    public void addTwoNumbers() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(5);
        node2.next = node3;

        ListNode result = addTwoNumbers(node1, node1);
        System.out.println(result);
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode result = null;
        ListNode resultTail = null;
        int carry = 0;
        while (head1 != null || head2 != null || carry != 0) {

            if (head1 != null && head2 != null) {
                if (result == null) {
                    int sum = head1.val + head2.val;
                    result = new ListNode(sum % 10);
                    resultTail = result;
                    carry = sum / 10;
                } else {
                    int sum = head1.val + head2.val + carry;
                    resultTail.next = new ListNode((sum % 10));
                    resultTail = resultTail.next;
                    carry = sum / 10;
                }
                head1 = head1.next;
                head2 = head2.next;
            } else if (head1 == null && head2 != null) {
                int sum = head2.val + carry;
                resultTail.next = new ListNode((sum % 10));
                resultTail = resultTail.next;
                carry = sum / 10;
                head2 = head2.next;
            } else if (head1 != null) {
                int sum = head1.val + carry;
                resultTail.next = new ListNode((sum % 10));
                resultTail = resultTail.next;
                carry = sum / 10;
                head1 = head1.next;
            } else {
                resultTail.next = new ListNode((carry));
                resultTail = resultTail.next;
                carry = 0;
            }
        }

        return result;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode result = null;
        ListNode resultTail = null;
        int carry = 0;
        int sum;
        while (head1 != null || head2 != null || carry != 0) {

            if (head1 != null && head2 != null) {
                if (result == null) {
                    sum = head1.val + head2.val;
                    result = new ListNode(sum % 10);
                    resultTail = result;
                    carry = sum / 10;
                } else {
                    sum = head1.val + head2.val + carry;
                    tailListNode(resultTail, sum % 10);
                    carry = sum / 10;
                }
                head1 = head1.next;
                head2 = head2.next;
            } else if (head1 == null && head2 != null) {
                sum = head2.val + carry;
                tailListNode(resultTail, sum % 10);
                carry = sum / 10;
                head2 = head2.next;
            } else if (head1 != null) {
                sum = head1.val + carry;
                tailListNode(resultTail, sum % 10);
                carry = sum / 10;
                head1 = head1.next;
            } else {
                tailListNode(resultTail, carry);
                carry = 0;
            }
        }

        return result;
    }

    private ListNode tailListNode(ListNode head, int val) {
        head.next = new ListNode((val));
        head = head.next;
        return head;
    }


    public static void main(String[] args) {

    }


}
