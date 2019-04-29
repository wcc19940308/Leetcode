package LeetCode100;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (int num : nums) {
            set.add(num);
        }

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int curNum = num;
                int longestRes = 1;
                while (set.contains(curNum + 1)) {
                    curNum++;
                    longestRes++;
                }
                res = Math.max(longestRes, res);
            }
        }
        return res;
    }
}
