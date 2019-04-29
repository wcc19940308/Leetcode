package LeetCode100;

import java.util.Stack;

/**
 *
 *
 *
 */
public class LargestRectangleInHistogram {
    public static int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] nums = new int[len + 1];
        for (int i = 0; i < heights.length; i++) {
            nums[i] = heights[i];
        }
        nums[len] = 0;
        Stack<Integer> stack = new Stack<>();
        int index = 0, maxArea = 0;
        while (index < len + 1) {
            if (stack.isEmpty() || nums[stack.peek()] < nums[index]) {
                stack.push(index);
                index++;
            } else {
                Integer pop = stack.pop();
                maxArea = Math.max(maxArea, nums[pop] * (stack.isEmpty() ? index : index - stack.peek() - 1));
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(arr));
    }
}
