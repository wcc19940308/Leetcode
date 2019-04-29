package LeetCode100;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. Combinations
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        backTrack(list, new ArrayList<>(), n, k, 1);
        return list;
    }

    public void backTrack(List<List<Integer>> list, List<Integer> tmpList, int n, int k, int start) {
        if (tmpList.size() == k) {
            list.add(new ArrayList<>(tmpList));
        }
        for (int i = start; i <= n; i++) {
            tmpList.add(i);
            backTrack(list, tmpList, n, k, i + 1);
            tmpList.remove(tmpList.size() - 1);
        }
    }
}
