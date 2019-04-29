package LeetCode100;
import java.util.*;

/**
 *
 * 301.Remove Invalid Parentheses
 *
 * http://www.cnblogs.com/grandyang/p/4944875.html
 *
 * 1.check whether a input string is valid
 * count(')') <= count('('), i < n - 1
 * count(')') == count('('), i == n - 1
 *
 * 2.compute min number of '(' and ')' to remove unbalanced ')' + unbalanced '('
 * "(a)())()", l = 0, r = 1
 * "(()", l = 1, r = 0
 * ")(", l = 1, r = 1
 *
 * 3.try all possible ways to remove r ")"s and l "("s. Remove ")" first to make prefix valid 如果先移除左括号可能最后剩下的字符串不是合法的
 * dfs(s, l, r):
 *      if l == 0 and r == 0 and valid(s):
 *          ans.add(s)
 * avoid duplications:
 * "(()" => "()", "(()" => "()"
 * only remove the first pransethesis if there are consecutive ones. 如果有连续的括号那么只移除第一个，因为如果第一个是正确的，那么无论移除后面
 * 的哪一个都是正确，但是应该避免重复的解
 *
 * 每次根据2判断不平衡的左括号和右括号数量，然后从左到右遍历字符串，删除相应的左括号，在根据1判断删除后的是否合法
 *
 */
public class RemoveInvalidParentheses {
    public List<String> removeInvalidParenthesesBFS(String s) {
        List<String> list = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        boolean found = false;
        set.add(s);
        queue.offer(s);
        while (!queue.isEmpty()) {
            String top = queue.poll();
            if (isValid(top)) {
                found = true;
                list.add(top);
            }
            if (found) continue;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != '(' && s.charAt(i) != ')') continue;
                String t = s.substring(0, i) + s.substring(i + 1);
                if (!set.contains(t)) {
                    set.add(t);
                    queue.offer(t);
                }
            }
        }
        return list;
    }

    public List<String> removeInvalidParenthesesDFS(String s) {
        List<String> list = new ArrayList<>();
        int l = 0, r = 0;
        // 判断括号中不平衡的左括号和右括号数量
        for (char ch : s.toCharArray()) {
            if (ch == '(') l++;
            if (l == 0 && ch == ')') r++;
            if (l > 0 && ch == ')') l--;
        }
        helper(s, 0, l, r, list);
        return list;
    }

    public void helper(String s, int start, int left, int right, List<String> list) {
        if (left == 0 && right == 0) {
            if (isValid(s)) list.add(s);
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (i > start && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            if (s.charAt(i) == ')' && right > 0) {
                helper(s.substring(0, i) + s.substring(i + 1), i, left, right - 1, list);
            }
            if (s.charAt(i) == '(' && left > 0) {
                helper(s.substring(0, i) + s.substring(i + 1), i, left - 1, right, list);
            }
        }
    }


    // 判断括号是否合法
    public boolean isValid(String s) {
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') count++;
            if (ch == ')') count--;
            if (count < 0) return false;
        }
        return count == 0;
    }

    public static void main(String[] args) {
        String s = "12345";
        System.out.println(s.substring(2));
    }
}
