import model.ListNode;

/**
 * 给定一个链表，旋转链表，使得每个节点向右移动k个位置，其中k是一个非负数
 */
public class M_170_RotateRight {

    public ListNode rotateRight(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        int length = getLength(head);
        n = n % length;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        ListNode tail = dummy;
        for (int i = 0; i < n; i++) {
            head = head.next;
        }

        while (head.next != null) {
            tail = tail.next;
            head = head.next;
        }

        head.next = dummy.next;
        dummy.next = tail.next;
        tail.next = null;
        return dummy.next;
    }

    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
