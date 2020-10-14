package pers.captain.algorithm.June;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import pers.captain.algorithm.structrue.ListNode;

/**
 * Input: 1->1->2
 * Output: 1->2
 * <p>
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 */
public class RemoveDuplicatesfromSortedList_83 {

    public static ListNode deleteDuplicates(ListNode head) {

        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }


    @Test
    public void test() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        node1.next = node2;
        ListNode node3 = new ListNode(2);
        node2.next = node3;

        ListNode node4 = new ListNode(2);
        node3.next = node4;

        node1 = deleteDuplicates(node1);

        System.out.println(JSON.toJSONString(node1));
    }
}
