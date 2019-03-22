package LeetCode100;

import java.util.regex.Pattern;

public class ConvertBSTToGreaterTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static int sum = 0;
    public static TreeNode convertBST(TreeNode root) {
        getSum(root);
        return root;
    }

    public static void getSum(TreeNode root) {
        if (root == null) {
            return;
        }
        if(root.right!=null) getSum(root.right);

        root.val += sum;
        sum = root.val;

        if(root.left!=null) getSum(root.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        convertBST(root);
        System.out.println(Pattern.compile(root.left.val + " " + root.val + " " + root.right.val));
    }
}
