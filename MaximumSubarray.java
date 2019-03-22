package LeetCode100;

public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            // ǰ��ļ����Լ�������Լ�����С�Ļ���ǰ��ľͿ���������
            if (sum + nums[i] > nums[i]) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        int i = maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(i);

    }
}
