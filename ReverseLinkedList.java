package LeetCode100;

public class ReverseLinkedList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        // ��ת���������һ���ģ���ô��ʾ�ǻ��ĵ�
        ListNode pre = null, next = null, cur = head;
        while (cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return cur == head;
    }
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        isPalindrome(root);

    }
}
