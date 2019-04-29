package LeetCode100;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 297. Serialize and Deserialize Binary Tree
 *
 */
public class SerializeandDeserializeBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
  }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serialize(root, new StringBuilder()).toString();
    }
    public StringBuilder serialize(TreeNode root,StringBuilder sb) {
        if (root == null) return sb.append("#").append(",");
        sb.append(root.val).append(",");
        serialize(root.left, sb);
        serialize(root.right, sb);
        return sb;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return deserialize(new LinkedList<>(Arrays.asList(data.split(","))));
    }
    public TreeNode deserialize(Queue<String> queue) {
        String top = queue.poll();
        if (top.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(top));
        root.left = deserialize(queue);
        root.right = deserialize(queue);
        return root;
    }
}
