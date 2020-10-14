package pers.captain.algorithm.sep.first;

import pers.captain.algorithm.structrue.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 输入两个链表，找出它们的第一个公共结点。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 */
public class FindFirstCommonNode {

    /**
     * 方法一： 使用map来记录一个链表的地址
     * 时间复杂度：O(MAX(m,n))  空间复杂度  O(MAX(m,n))
     *
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) return null;
        ListNode firstCommonNode = null;
        Set<ListNode> set = new HashSet<>();
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != null) {
            set.add(p1);
            p1 = p1.next;
        }

        while (p2 != null) {
            if (set.contains(p2)) {
                firstCommonNode = p2;
                break;
            }
            p2 = p2.next;
        }
        return firstCommonNode;
    }

    /**
     * 方法一： 两个指针
     * 时间复杂度：O(m+n)  空间复杂度  O(1)
     *
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) return null;
        // 获取两个聊表的长度
        int p1Len = getListNodeLength(pHead1);
        int p2Len = getListNodeLength(pHead2);
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        // pHead1 长，先走 p1Len- p2Len 步
        if (p1Len > p2Len) {
            while (p1Len > p2Len) {
                p1 = p1.next;
                p1Len--;
            }
        } // pHead2 长，先走 p2Len- p1Len 步
        else if (p2Len > p1Len) {
            while (p2Len > p1Len) {
                p2 = p2.next;
                p2Len--;
            }
        }
        // pHead1 和 pHead2 起头并进
        while (p1 != null && p1 != p2) {
            p2 = p2.next;
            p1 = p1.next;
        }
        return p1;

    }

    private int getListNodeLength(ListNode listNode) {
        int length = 0;
        ListNode current = listNode;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }
}
