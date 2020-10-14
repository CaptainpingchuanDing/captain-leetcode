package pers.captain.algorithm.structrue;


public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode fake = new ListNode(0);
        fake.next = this;
        while (fake.next != null) {
            sb.append(fake.next.val);
            sb.append("-->");
            fake = fake.next;
        }
        if (sb.length() != 0) {
            sb.delete(sb.length() - 3, sb.length());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        head.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;

    }
}
