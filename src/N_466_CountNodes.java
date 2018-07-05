import model.ListNode;

/**
 * 计算链表中有多少个节点
 */
public class N_466_CountNodes {
    public int countNodes(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}
