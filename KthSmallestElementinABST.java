package LeetCode100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KthSmallestElementinABST {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isValidBST(TreeNode root) {
        int pre = Integer.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val > pre) {
                pre = root.val;
                root = root.right;
            } else {
                return false;
            }
        }
        return true;
    }
}
