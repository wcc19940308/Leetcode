package LeetCode100;


import java.util.*;

/**
 *
 * 239. Sliding Window Maximum
 *
 * 一共n - k + 1个滑动窗口，用过双端队列来记录数组的索引，当双端队列中最前端的索引值过期的时候，丢弃（这里的滑动窗口是从后往前计算的）
 * 如果下一个数组的元素值比当前队列的最后一个大，那么只需要记录下一个数组的值即可，当前队列中的值都无效，丢弃即可，即队列保持降序
 * 最后，队列中的首元素对应的值就是每次滑动窗口中的最大值
 *
 */
public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k < 0) {
            return new int[0];
        }
        // 一共有n-k+1个滑动窗口
        int[] res = new int[n - k + 1];
        int index = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offer(i);
            if (i - k + 1 >= 0) {
                res[index++] = deque.peekFirst();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] ints = maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(ints));
    }
}
