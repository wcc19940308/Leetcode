package LeetCode100;

import java.util.ArrayList;
import java.util.List;

// 字符串匹配使用滑动窗口
public class FindAllAnagramsInAString {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int[] hash = new int[26];
        int count = p.length();
        int left = 0, right = 0;
        for (char ch : p.toCharArray()) {
            // 将hash数组中的含有p的那些位置为1
            hash[ch - 'a']++;
        }
        while (right < s.length()) {
            if (--hash[s.charAt(right++) - 'a'] >= 0) count--;
            if (count == 0) list.add(left);
            if ((right - left == p.length()) && hash[s.charAt(left++) - 'a']++ >= 0) count++;
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> list = findAnagrams("cbaebabacd", "abc");
        System.out.println(list.toString());
    }
}
