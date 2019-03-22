package LeetCode100;

public class SymmetricTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSymmetric(TreeNode root) {
        boolean res = isMirror(root, root);
        return res;
    }

    public boolean isMirror(TreeNode root1, TreeNode root2) {
        if (root1.val == root2.val)
            return true;
        if (root1==null || root2==null)
            return false;

        return isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
    }
}
