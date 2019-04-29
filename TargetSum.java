package LeetCode100;

/**
 * 494. Target Sum
 *
 * 1.DFS进行求解：2^n
 * 2.DP
 */
public class TargetSum {
    int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        dfs(nums, 0, 0, S);
        return count;
    }

    public void dfs(int[] nums, int i, int sum, int S) {
        if (i == nums.length) {
            if (sum == S) {
                count++;
            }
        } else {
            dfs(nums, i + 1, sum + nums[i], S);
            dfs(nums, i + 1, sum - nums[i], S);
        }
    }


}
