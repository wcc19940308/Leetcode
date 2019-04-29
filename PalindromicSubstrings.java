package LeetCode100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromicSubstrings {
    int count = 0;
    public  int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            judge(s, i, i);
            judge(s, i, i + 1);
        }
        return count;
    }

    public void judge(String s, int left, int right) {
        while (left < right) {
            if (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }
        }
    }
}
