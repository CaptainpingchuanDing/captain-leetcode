package pers.captain.algorithm.offer.four;

import pers.captain.algorithm.structrue.ListNode;

/**
 * 题目描述
 * 输入两个链表，找出它们的第一个公共结点。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 */
public class NO36FindFirstCommonNode {
    /**
     * 方法一： 计算两个链表的长度，m1 m2
     * 第一个长的链表先走 m2 -m1
     *
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        int len1 = 0;
        int len2 = 0;
        while (p1 != null || p2 != null) {
            if (p1 != null) {
                len1++;
                p1 = p1.next;
            }
            if (p2 != null) {
                len2++;
                p2 = p2.next;
            }
        }
        p1 = pHead1;
        p2 = pHead2;
        if (len1 > len2) {
            for (int i = 0; i < len1 - len2; i++) {
                p1 = p1.next;
            }
        }
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    /**
     * 方法二：
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
     //1 2 3 4 5
     //6 7 3
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while(p1 != p2) {
            if(p1 != null) p1 = p1.next;    //防止空指针异常
            if(p2 != null) p2 = p2.next;
            if(p1 != p2) {                  //当两个链表长度不想等
                if(p1 == null) p1 = pHead1;
                if(p2 == null) p2 = pHead2;
            }
        }
        return p1;
    }
}
