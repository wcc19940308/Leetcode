package LeetCode100;

import java.util.*;

public class MaxCoins {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNum = new int[n + 2];
        newNum[0] = 1;
        newNum[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            newNum[i] = nums[i - 1];
        }
        int[][] dp = new int[n + 2][n + 2];
        for (int len = 1; len <= n; len++) {
            for (int i = 1; i <= n - len + 1; i++) {
                int j = i + len - 1;
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j],
                            dp[i][k - 1] + dp[k + 1][j] + newNum[i - 1] * newNum[k] * newNum[j + 1]);
                }
            }
        }
        return dp[1][n];
    }
}
