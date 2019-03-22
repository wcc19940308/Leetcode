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
            // ��������е�ÿ���ڵ㣬�����ǵ����������������ĵѿ�������ͼ���
            total += count(lo, i - 1) * count(i + 1, hi);
        }
        return total;
    }
}
