package LeetCode100;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backTrack(list, sb, 0, 0, n);
        return list;
    }

    public void backTrack(List<String> list, StringBuilder sb, int open, int close, int max) {
        if (open == max && close == max) {
            list.add(sb.toString());
            return;
        }

        if (open < max) {
            sb.append("(");
            backTrack(list, sb, open + 1, close, max);
            sb.setLength(sb.length() - 1);
        }

        if (close < open) {
            sb.append(")");
            backTrack(list, sb, open, close + 1, max);
            sb.setLength(sb.length() - 1);
        }
    }
}
