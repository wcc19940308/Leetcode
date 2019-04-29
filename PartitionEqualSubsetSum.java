package LeetCode100;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PartitionEqualSubsetSum {
    public static boolean canPartition(int[] nums) {
//        int sum = 0;
//        for (int num : nums) {
//            sum += num;
//        }
//        if ((sum & 1) != 0) {
//            return false;
//        }
//        int n = nums.length;
//        sum /= 2;
//        boolean[][] dp = new boolean[n + 1][sum + 1];
//        dp[0][0] = true;
//        for (int i = 0; i <= n; i++) {
//            dp[i][0] = true;
//        }
//
//        for (int i = 0; i <= sum; i++) {
//            dp[0][i] = false;
//        }
//
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= sum; j++) {
//                if (j >= nums[i - 1]) {
//                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
//                } else {
//                    dp[i][j] = dp[i - 1][j];
//                }
//            }
//        }
//        return dp[n][sum];

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) != 0) {
            return false;
        }
        int n = nums.length;
        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = sum; i > 0; i--) {
                if (i >= num) {
                    dp[i] = dp[i] || dp[i - num];
                }
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1};
        System.out.println(canPartition(nums));
    }
}
