package LeetCode100;

public class IntersectionOfTwoLinkedLists {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        int count1 = 0, count2 = 0;
        int sub = 0;
        while (p1 != null) {
            count1++;
            p1 = p1.next;
        }
        p1 = headA;
        while (p2 != null) {
            count2++;
            p2 = p2.next;
        }
        p2 = headB;
        sub = Math.abs(count1 - count2);
        if (count1 > count2) {
            while (sub-- > 0) {
                p1 = p1.next;
            }
            while (p1 != p2) {
                p1 = p1.next;
                p2 = p2.next;
            }
            return p1;
        } else {
            while (sub-- > 0) {
                p2 = p2.next;
            }
            while (p1 != p2) {
                p1 = p1.next;
                p2 = p2.next;
            }
            return p1;
        }
    }
}
