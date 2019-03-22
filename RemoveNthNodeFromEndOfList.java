package LeetCode100;

public class RemoveNthNodeFromEndOfList {
    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = new ListNode(0);
        ListNode p1 = newHead, p2 = newHead;
        p1.next = head;
        while (n-- > 0) {
            p2 = p2.next;
        }
        p2 = p2.next;
        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p1.next.next;
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode listNode = removeNthFromEnd(node, 1);
    }
}
