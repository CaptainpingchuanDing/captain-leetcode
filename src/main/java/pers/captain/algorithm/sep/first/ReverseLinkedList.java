package pers.captain.algorithm.sep.first;

import org.junit.Test;
import pers.captain.algorithm.structrue.ListNode;

import java.util.Stack;

/**
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseLinkedList {

    /**
     * 使用栈
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        Stack<ListNode> stack = new Stack<>();
        ListNode current = head;
        while (current != null) {
            ListNode temp = current;
            stack.push(temp);
            current = current.next;
            temp.next = null;
        }
        ListNode dummy = new ListNode(0);
        current = dummy;
        while (stack.size() > 0) {
            current.next = stack.pop();
            current = current.next;
        }

        return dummy.next;
    }

    @Test
    public void reverseList() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        head.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;

        ListNode result = reverseList(head);
        System.out.println(result.toString());
    }

    /**
     * 方法二：使用递归的方式
     *
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        reverseListHelper(head, head.next, dummy);
        return dummy.next;
    }

    private ListNode reverseListHelper(ListNode current, ListNode rest, ListNode reverseHead) {
        if (rest == null) {
            reverseHead.next = current;
        } else {
            ListNode reverseTail = reverseListHelper(rest, rest.next, reverseHead);
            reverseTail.next = current;
            current.next = null;
        }
        return current;
    }

    @Test
    public void reverseList1() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        head.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;

        ListNode result = reverseList1(head);
        System.out.println(result.toString());
    }

    /**
     * 方法三：双指针法   中间多在用一个临时的变量  后面的节点依次放在头节点
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null) return null;
        ListNode current = head;
        ListNode pre = null;
        while (current != null) {
            ListNode temp = current;
            current = current.next;
            temp.next = pre;
            pre = temp;
        }
        return pre;
    }
    @Test
    public void reverseList2() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        head.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;

        ListNode node4 = new ListNode(4);
        node3.next = node4;


        ListNode result = reverseList2(head);
        System.out.println(result.toString());
    }

}
