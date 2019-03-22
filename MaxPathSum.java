package LeetCode100;

import java.util.*;

public class MaxPathSum {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static int maxValue;
    public static int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        getMaxFromRoot(root);
        return maxValue;
    }

    public static int getMaxFromRoot(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, getMaxFromRoot(root.left));
        int right = Math.max(0, getMaxFromRoot(root.right));
        maxValue = Math.max(maxValue, root.val + left + right);
        return Math.max(left, right) + root.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(maxPathSum(root));
    }
}
