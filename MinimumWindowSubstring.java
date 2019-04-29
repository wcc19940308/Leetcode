package LeetCode100;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int[] hash = new int[128];
        int from = 0;
        int min = Integer.MAX_VALUE;
        int total = t.length();
        for (char ch : t.toCharArray()) {
            hash[ch]++;
        }
        // ◊Û”“÷∏’Îi∫Õj
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (hash[s.charAt(j)]-- > 0) total--;
            while (total == 0) {
                if (j - i + 1 < min) {
                    from = i;
                    min = j - i + 1;
                }
                if (++hash[s.charAt(i++)] > 0) total++;
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(from, from + min);
    }
}
