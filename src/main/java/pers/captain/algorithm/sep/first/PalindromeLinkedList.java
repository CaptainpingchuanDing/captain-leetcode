package pers.captain.algorithm.sep.first;

import org.junit.Assert;
import org.junit.Test;
import pers.captain.algorithm.structrue.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 234. 回文链表
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * <p>
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class PalindromeLinkedList {
    /**
     * 1. 两个指针，一个一步一步走，一个两步两步走，快的走到
     * <p>
     * 2. 一个栈把慢指针走的节点记录下来。
     * <p>
     * 注意：当链表是奇数时，满指针的最后一次遍历的元素不需要进栈
     * <p>
     * 时间复杂度：O（n） 空间复杂度 O(n/2)
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode fast = head;
        ListNode slow = fast;
        Stack<ListNode> slowListNodeStack = new Stack<>();
        slowListNodeStack.push(slow);
        while (true) {
            if (fast.next == null) {// 走到链表尾部
                slowListNodeStack.pop();
                break;
            }
            if (fast.next.next != null) {// fast可以继续走
                fast = fast.next.next;
                slow = slow.next;
                slowListNodeStack.push(slow);
            } else {// fast走到倒数第二个节点停止
                break;
            }
        }

        while (slow.next != null) {
            if (slowListNodeStack.pop().val == slow.next.val) {
                slow = slow.next;
            } else {
                return false;
            }
        }
        return true;
    }

    @Test
    public void isPalindrome1_1() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        head.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;

        boolean result = isPalindrome(head);
        Assert.assertFalse(result);

    }

    @Test
    public void isPalindrome1_2() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        head.next = node2;
        ListNode node3 = new ListNode(1);
        node2.next = node3;

        boolean result = isPalindrome(head);
        Assert.assertTrue(result);

    }


    /**
     * 方法二： 快慢指针
     * 时间复杂度O(n)  空间复杂度O(1)
     * <p>
     * 慢指针指到后半部分的开头，然后把后面的链表翻转，然后和前部分的一一比较，之后再把后半部分的链表翻转回来
     *
     * @param head
     * @return
     */
    public boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode fast = head;
        ListNode slow = fast;

        while (true) {
            if (fast.next != null && fast.next.next != null) {// fast可以继续走
                fast = fast.next.next;
                slow = slow.next;
            } else {
                break;
            }
        }
        // 翻转链表的后半部分
        ListNode reverseHead = reverse(slow.next);
        ListNode originCurrent = head;
        ListNode reverseHeadCur = reverseHead;
        // 前半部分对比 后半部分翻转之后的链表
        while (reverseHeadCur != null) {
            if (reverseHeadCur.val != originCurrent.val) {
                //todo 咨询时候要复原链表
                slow.next = reverse(reverseHead);
                return false;
            }
            reverseHeadCur = reverseHeadCur.next;
            originCurrent = originCurrent.next;
        }
        // 复原 todo 咨询时候要复原链表
        slow.next = reverse(reverseHead);

        return true;
    }

    private ListNode reverse(ListNode head) {
        if (head == null) return null;
        // 1 2 3
        ListNode cur = head;
        ListNode reversHead = null;
        while (cur != null) {
            if (reversHead == null) {
                reversHead = cur;
                cur = cur.next;
                //todo 一开始忘记加了
                reversHead.next = null;
            } else {
                ListNode temp = cur;
                cur = cur.next;
                temp.next = reversHead;
                reversHead = temp;
            }
        }
        return reversHead;
    }

    @Test
    public void isPalindrome2_1() {
        ListNode head = new ListNode(0);
        ListNode node2 = new ListNode(0);
        head.next = node2;


        boolean result = isPalindrome2(head);
        Assert.assertTrue(result);

    }

    @Test
    public void isPalindrome2_2() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        head.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;

        boolean result = isPalindrome2(head);
        Assert.assertFalse(result);

    }

    @Test
    public void isPalindrome2_3() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        head.next = node2;
        ListNode node3 = new ListNode(2);
        node2.next = node3;

        ListNode node4 = new ListNode(1);
        node3.next = node4;

        boolean result = isPalindrome2(head);
        Assert.assertTrue(result);

    }


    /**
     * 方法三：时间复杂度O(n) 空间复杂度O(n)
     * 将链表复制到数组中，用双指针
     *
     * @param head
     * @return
     */
    public boolean isPalindrome3(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode cur = head;
        List<Integer> list = new ArrayList<>();
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        int left = 0;
        int right = list.size() - 1;
        while (right > left) {
            if ((list.get(left) - list.get(right))!=0) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    @Test
    public void isPalindrome3_1() {
//        ListNode head = new ListNode(0);
//        ListNode node2 = new ListNode(0);
//        head.next = node2;

        ListNode head = new ListNode(0-129);
        ListNode node2 = new ListNode(0-129);
        head.next = node2;

        boolean result = isPalindrome3(head);
        Assert.assertTrue(result);

    }

    @Test
    public void isPalindrome3_2() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        head.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;

        boolean result = isPalindrome3(head);
        Assert.assertFalse(result);

    }

    @Test
    public void isPalindrome3_3() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        head.next = node2;
        ListNode node3 = new ListNode(2);
        node2.next = node3;

        ListNode node4 = new ListNode(1);
        node3.next = node4;

        boolean result = isPalindrome3(head);
        Assert.assertTrue(result);

    }

}
