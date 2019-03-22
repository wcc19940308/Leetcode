package LeetCode100;

public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int count = count(1, n);
        return count;
    }

    public int count(int lo, int hi) {
        if (lo >= hi) return 1;
        int total = 0;
        for (int i = lo; i <= hi; i++) {
            // 针对序列中的每个节点，将它们的左子树和右子树的笛卡尔积求和即可
            total += count(lo, i - 1) * count(i + 1, hi);
        }
        return total;
    }
}
