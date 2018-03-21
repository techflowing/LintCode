import model.ListNode;

/**
 * 给定一个排序链表，删除所有重复的元素每个元素只留下一个。
 */
public class E_112_DeleteDuplicates {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode node = head;
        while (node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }
}
