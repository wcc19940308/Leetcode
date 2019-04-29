package LeetCode100;

import java.util.Stack;

public class Inpreorder {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void inpreoder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                System.out.println(root.val);
                stack.push(root.right);
                root = root.left;
            }
            root = stack.pop();
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = root.left = new TreeNode(2);
        TreeNode right = root.right = new TreeNode(3);
        inpreoder(root);

    }
}
