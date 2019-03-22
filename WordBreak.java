package LeetCode100;

import java.util.*;


public class WordBreak {
    // DP»òÕßBFS£¬BFS½«
    public static boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        Queue<Integer> queue = new LinkedList<Integer>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(0);
        visited.add(0);
        while (!queue.isEmpty()) {
            Integer curIndex = queue.poll();
            for (int i = curIndex + 1; i <= len; i++) {
                if (!visited.contains(i)) {
                    if (wordDict.contains(s.substring(curIndex, i))) {
                        if (i == len) {
                            return true;
                        }
                        queue.offer(i);
                        visited.add(i);
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "catsandog";
        List<String> wordDict = Arrays.asList(new String[]{"cats", "dog", "sand", "and", "cat"});
        System.out.println(wordBreak(s, wordDict));
    }
}


