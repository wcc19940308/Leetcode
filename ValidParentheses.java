package LeetCode100;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        if (s == "") {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            switch(ch){
                case '(': case '{': case'[':
                    stack.push(ch);
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                    default:
                        break;
            }
        }
        return stack.isEmpty();
    }
}
