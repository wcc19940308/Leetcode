package LeetCode100;

public class LinkedListCycle {
   static class ListNode{
       int val;
       ListNode next;

       ListNode(int x) {
           val = x;
           next = null;
       }
   }

    public static boolean hasCycle(ListNode head) {
       if (head==null || head.next==null){
           return false;
       }
        ListNode p1 = head;
        ListNode p2 = head;
        while (p1 != p2) {
            if (p2 == null || p2.next == null) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        System.out.println(hasCycle(node));
    }

}
