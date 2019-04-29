package LeetCode100;

import java.util.Arrays;

public class TaskScheduler {
    public static int leastInterval(char[] tasks, int n) {
        int[] hash = new int[26];
        for (char task : tasks) {
            hash[task - 'A']++;
        }
        Arrays.sort(hash);
        int maxCount = 0;
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] == hash[25]) {
                maxCount++;
            }
        }
        return Math.max((hash[25] - 1) * (n + 1) + maxCount, tasks.length);
    }

    public static void main(String[] args) {
        char[] chars = new char[]{'A', 'A', 'A', 'B', 'B', 'B'};
        System.out.println(leastInterval(chars, 2));

    }
}
