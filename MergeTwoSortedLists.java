package LeetCode100;

public class MergeTwoSortedLists {
    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        while (l1 != null || l2 != null) {
            if (l1 != null || l2 != null) {
                if (l1.val <= l2.val) {
                    ListNode node = new ListNode(l1.val);
                    p.next = node;
                    p = node;
                    l1 = l1.next;
                } else {
                    ListNode node = new ListNode(l2.val);
                    p.next = node;
                    p = node;
                    l2 = l2.next;
                }
            } else if (l1 != null) {
                ListNode node = new ListNode(l1.val);
                p.next = node;
                p = node;
                l1 = l1.next;
            } else {
                ListNode node = new ListNode(l2.val);
                p.next = node;
                p = node;
                l2 = l2.next;
            }
        }
        return head.next;
    }
}
