package LeetCode100;



public class DimaterOfBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        getMaxDepth(root);
        return max;
    }

    public int getMaxDepth(TreeNode root) {
        if(root == null) return 0;
        int left = getMaxDepth(root.left);
        int right = getMaxDepth(root.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }
}
