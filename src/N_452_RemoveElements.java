import model.ListNode;

/**
 * 删除链表中等于给定值val的所有节点。
 */
public class N_452_RemoveElements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        while (head.next != null) {
            if (head.next.val == val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }

        return dummy.next;
    }
}
