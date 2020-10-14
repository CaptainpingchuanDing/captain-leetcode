package pers.captain.algorithm.last;

import com.alibaba.fastjson.JSON;

/**
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class No28MergeTwoSortedLists_21 {


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode head = null;
        // 尾节点
        ListNode headIndex = null;

        ListNode l1Head = l1;
        ListNode l2Head = l2;
        while (l1Head != null || l2Head != null) {
            if (l1Head != null && l2Head != null) {
                int tempMin;
                if (l1Head.val < l2Head.val) {
                    tempMin = l1Head.val;
                    l1Head = l1Head.next;
                } else {
                    tempMin = l2Head.val;
                    l2Head = l2Head.next;
                }
                ListNode temp = new ListNode(tempMin);
                if (head == null) {
                    head = temp;
                    headIndex = temp;
                } else {
                    headIndex.next = temp;
                    headIndex = temp;
                }

            } else if (l1Head != null) {

                ListNode temp = new ListNode(l1Head.val);
                if (head == null) {
                    head = temp;
                } else {
                    headIndex.next = temp;
                }
                headIndex = temp;
                l1Head = l1Head.next;
            } else {
                ListNode temp = new ListNode(l2Head.val);
                if (head == null) {
                    head = temp;
                } else {
                    headIndex.next = temp;
                }
                headIndex = temp;
                l2Head = l2Head.next;
            }
        }
        return head;
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode head = null;
        // 尾节点
        ListNode headIndex = null;

        ListNode l1Head = l1;
        ListNode l2Head = l2;
        while (l1Head != null || l2Head != null) {
            int tempMin;
            if (l1Head != null && l2Head != null) {
                if (l1Head.val < l2Head.val) {
                    tempMin = l1Head.val;
                    l1Head = l1Head.next;
                } else {
                    tempMin = l2Head.val;
                    l2Head = l2Head.next;
                }
            } else if (l1Head != null) {
                tempMin = l1Head.val;
                l1Head = l1Head.next;
            } else {
                tempMin = l2Head.val;
                l2Head = l2Head.next;
            }
            ListNode temp = new ListNode(tempMin);
            if (head == null) {
                head = temp;
                headIndex = temp;
            } else {
                headIndex.next = temp;
                headIndex = temp;
            }
        }
        return head;
    }



    public static void main(String[] args) {
        No28MergeTwoSortedLists_21 no28MergeTwoSortedLists21 = new No28MergeTwoSortedLists_21();
        ListNode l1 = new ListNode(1);
        ListNode l1_2 = new ListNode(2);
        l1.next = l1_2;

        ListNode l2 = new ListNode(2);
        ListNode l2_2 = new ListNode(3);
        l2.next = l2_2;

        ListNode listNode = no28MergeTwoSortedLists21.mergeTwoLists1(l1, l2);
        System.out.println(JSON.toJSONString(listNode));
    }

}
