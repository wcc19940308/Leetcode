package LeetCode100;


import java.util.*;

/**
 *
 * 239. Sliding Window Maximum
 *
 * һ��n - k + 1���������ڣ��ù�˫�˶�������¼�������������˫�˶�������ǰ�˵�����ֵ���ڵ�ʱ�򣬶���������Ļ��������ǴӺ���ǰ����ģ�
 * �����һ�������Ԫ��ֵ�ȵ�ǰ���е����һ������ôֻ��Ҫ��¼��һ�������ֵ���ɣ���ǰ�����е�ֵ����Ч���������ɣ������б��ֽ���
 * ��󣬶����е���Ԫ�ض�Ӧ��ֵ����ÿ�λ��������е����ֵ
 *
 */
public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k < 0) {
            return new int[0];
        }
        // һ����n-k+1����������
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
