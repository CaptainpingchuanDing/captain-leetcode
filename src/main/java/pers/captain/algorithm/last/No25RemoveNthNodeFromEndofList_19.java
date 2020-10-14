package pers.captain.algorithm.last;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 */
public class No25RemoveNthNodeFromEndofList_19 {

    /**
     * 两个指针
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode tempHead = head;
        ListNode lowIndex = head;
        ListNode fastIndex = head;

        while (tempHead != null) {
            // 快的指针先走n步
            while (tempHead != null && n > 0) {
                fastIndex = fastIndex.next;
                n--;
                tempHead = tempHead.next;
                if (fastIndex == null) {
                    return head.next;
                }
            }

            // 到达链表的尾部
            if (fastIndex.next == null) {
                lowIndex.next = lowIndex.next.next;
                break;
            }

            lowIndex = lowIndex.next;
            fastIndex = fastIndex.next;
            tempHead = tempHead.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        ListNode NO2 = new ListNode(2);
//        ListNode NO3 = new ListNode(3);
////
//        head.next = NO2;
//        NO2.next = NO3;

        No25RemoveNthNodeFromEndofList_19 nodeFromEndofList19 = new No25RemoveNthNodeFromEndofList_19();
        ListNode result = nodeFromEndofList19.removeNthFromEnd(head, 1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }


    }

}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
