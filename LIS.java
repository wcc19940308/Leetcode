package LeetCode100;

/**
 *
 * 300. Longest Increasing Subsequence
 * dp[i]代表到i位置的最长自增子数列的长度， 因此需要用一个变量记录历史的最大长度，而非返回最后一项的长度
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
                // 找出当前点的最大上升序列长度
                if (nums[i] > nums[j]) {
                    // 这里取max是为了不让每次i进行判断的时候被j的dp[j]覆盖掉
                    // 反例{1,3,6,7,9,4,10,5,6}
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
