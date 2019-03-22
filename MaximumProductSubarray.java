package LeetCode100;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int maxHere = nums[0];
        int minHere = nums[0];
        int maxRes = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = maxHere;
            maxHere = Math.max(Math.max(maxHere * nums[i], minHere * nums[i]), nums[i]);
            minHere = Math.min(Math.min(temp * nums[i], minHere * nums[i]), nums[i]);
            maxRes = Math.max(maxHere, maxRes);
        }
        return maxRes;
    }
}
