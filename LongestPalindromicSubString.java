package LeetCode100;

// 重点记录一下，使用双指针，从中间向两边遍历
public class LongestPalindromicSubString {
    private static int maxLen, lo;
    public static String longestPalindrome(String s) {
        if (s.length() == 0 || s == null) {
            return "";
        }
        for (int i = 0; i < s.length(); i++) {
            // 这里是为了解决奇偶回文串的问题，上面解决奇数，下面解决偶数
            findLongest(s, i, i);
            findLongest(s, i, i + 1);
        }
        return s.substring(lo, lo + maxLen);
    }

    public static void findLongest(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        if (maxLen < j - i - 1) {
            lo = i + 1;
            maxLen = j - i - 1;
        }
    }


    public static void main(String[] args) {
        System.out.println(longestPalindrome("ac"));
    }
}
