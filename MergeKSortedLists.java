package LeetCode100;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0 || lists==null) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        for (ListNode list : lists) {
            if (list != null)
                queue.offer(list);
        }

        while (!queue.isEmpty()) {
            ListNode top = queue.poll();
            head.next = top;
            head = head.next;
            if (head.next != null) {
                queue.offer(head.next);
            }
        }
        return dummy.next;
    }
}
