package pers.captain.algorithm.last;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No31SwapNodesinPairs_24 {

    /**
     * 递归的模式
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode yum = new ListNode(-1);
        swap(yum, head);
        return yum.next;
    }

    private void swap(ListNode swapResult, ListNode rest) {
        if (rest == null) {
            swapResult.next = null;
            return;
        }
        if (rest.next == null) {
            swapResult.next = rest;
        } else {
            ListNode newHead = rest.next;
            ListNode last = rest.next.next;
            newHead.next = rest;

            swapResult.next = newHead;
            swap(newHead.next, last);
        }

    }

    /**
     * 迭代
     *
     * @param head
     * @return
     */
    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode yum = new ListNode(-1);
        ListNode tempTail = null;

        ListNode index = head;
        while (index != null) {
            if (index.next == null) {
                tempTail.next = index;
                index = index.next;
            } else {
                if (yum.next == null) {
                    ListNode newHead =  index.next;
                    newHead.next = index;
                    yum.next = newHead;
                    tempTail = index;
                } else {
                    ListNode newHead =  index.next;
                    newHead.next = index;
                    tempTail.next = newHead;
                    tempTail = index;
                }
                index = index.next.next;

            }
        }

        return yum.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        No31SwapNodesinPairs_24 swapNodesinPairs_24 = new No31SwapNodesinPairs_24();
//        swapNodesinPairs_24.swapPairs(l1);
        swapNodesinPairs_24.swapPairs1(l1);
    }
}
