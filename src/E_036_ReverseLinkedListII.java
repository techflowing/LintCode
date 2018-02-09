import model.ListNode;

/**
 * 翻转链表中第m个节点到第n个节点的部分
 * 给出链表1->2->3->4->5->null， m = 2 和n = 4，返回1->4->3->2->5->null
 */
public class E_036_ReverseLinkedListII {

    /**
     * 首先创建一个tempHead指向头结点，并使用他来定位到第m个节点之前的节点，将curNode设置为preNode之后的节点，
     * 每次将curNode之后的节点（moveNode）移动到preNode之后的节点，重复n-m次
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m >= n || head == null || head.next == null) {
            return head;
        }

        ListNode tempHead = new ListNode(0);
        tempHead.next = head;

        ListNode preNode = tempHead;
        for (int i = 1; i < m; i++) {
            preNode = preNode.next;
        }
        ListNode curNode = preNode.next;
        for (int i = 0; i < n - m; i++) {
            ListNode moveNode = curNode.next;
            curNode.next = moveNode.next;
            moveNode.next = preNode.next;
            preNode.next = moveNode;
        }
        return tempHead.next;
    }
}
