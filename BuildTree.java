package LeetCode100;

import java.util.HashMap;
import java.util.Map;

public class BuildTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
  }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode res =
                recurive(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
        return res;
    }

    public TreeNode recurive(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd, Map<Integer, Integer> map) {
        if (preStart > preEnd || inStart > inEnd) return null;
        int num = preOrder[preStart];
        TreeNode root = new TreeNode(num);
//        for (int i = inStart; i <= inEnd; i++) {
//            if (num == inOrder[i]) {
//                root.left = recurive(preOrder, preStart + 1, preStart + i - inStart, inOrder, inStart, i - 1);
//                root.right = recurive(preOrder, preStart + i - inStart + 1, preEnd, inOrder, i + 1, inEnd);
//            }
//        }
        Integer i = map.get(num);
        root.left = recurive(preOrder, preStart + 1, preStart + i - inStart, inOrder, inStart, i - 1, map);
        root.right = recurive(preOrder, preStart + i - inStart + 1, preEnd, inOrder, i + 1, inEnd, map);
        return root;
    }
}
