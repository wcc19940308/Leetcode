package LeetCode100;

// �ص��¼һ�£�ʹ��˫ָ�룬���м������߱���
public class LongestPalindromicSubString {
    private static int maxLen, lo;
    public static String longestPalindrome(String s) {
        if (s.length() == 0 || s == null) {
            return "";
        }
        for (int i = 0; i < s.length(); i++) {
            // ������Ϊ�˽����ż���Ĵ������⣬������������������ż��
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
