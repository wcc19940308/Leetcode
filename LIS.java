package LeetCode100;

/**
 *
 * 300. Longest Increasing Subsequence
 * dp[i]����iλ�õ�����������еĳ��ȣ� �����Ҫ��һ��������¼��ʷ����󳤶ȣ����Ƿ������һ��ĳ���
 * LIS = max(dp[i])
 * dp[i] = max(dp[j]) + 1
 *
 */
public class LIS {
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < n; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                // �ҳ���ǰ�������������г���
                if (nums[i] > nums[j]) {
                    // ����ȡmax��Ϊ�˲���ÿ��i�����жϵ�ʱ��j��dp[j]���ǵ�
                    // ����{1,3,6,7,9,4,10,5,6}
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = 1 + maxval;
            res = Math.max(dp[i], res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,6,7,9,4,10,5,6};
        System.out.println(lengthOfLIS(arr));
    }
}
