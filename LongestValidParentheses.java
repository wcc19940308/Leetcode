package LeetCode100;

import java.util.Stack;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
                count++;
            } else if (ch == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                    count++;
                }
            }
        }
        return count;
    }
}
