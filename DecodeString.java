package LeetCode100;

import java.util.Stack;

public class DecodeString {
    public static String decodeString(String s) {
        Stack<Integer> intStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        int num = 0;
        String res = "";
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
            } else if (ch == '[') {
                num = 0;
                strStack.push(res);
                intStack.push(num);
                res = "";

            } else if (ch == ']') {
                Integer cnt = intStack.pop();
                StringBuilder sb = new StringBuilder(strStack.pop());
                while (cnt-- > 0) {
                    sb.append(res);
                }
                res = sb.toString();
            } else {
                res += ch;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
    }
}
