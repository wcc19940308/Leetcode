package LeetCode100;

public class PathSum3 {
    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return recursive(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public int recursive(TreeNode root, int sum) {
        if (root == null) return 0;
        return (root.val == sum ? 1 : 0) + recursive(root.left, sum - root.val) + recursive(root.right, sum - root.val);
    }
}
