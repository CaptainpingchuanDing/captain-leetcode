package pers.captain.algorithm.last;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class No29MergeKSortedLists {
    /**
     * 利用分治的方式进行
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) return null;
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int start, int end) {

        if (start == end) return lists[start];
        if (end - start == 1) {
            return mergeList(lists[start], lists[end]);
        } else {
            int mid = (start + end) / 2;
            ListNode leftResult = merge(lists, start, mid);
            ListNode rightResult = merge(lists, mid + 1, end);
            return mergeList(leftResult, rightResult);
        }
    }

    private ListNode mergeList(ListNode head1, ListNode head2) {
        ListNode head = null;
        ListNode headIndex = null;
        ListNode l1Head = head1;
        ListNode l2Head = head2;
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
}
