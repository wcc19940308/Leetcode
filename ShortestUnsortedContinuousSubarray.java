package LeetCode100;


/**
 *
 * 581. Shortest Unsorted Continuous Subarray
 *
 * 单次循环：
 * 保证从右向左扫描过程中，左边的都应该小于未排序范围内最小的那个
 * 从左向右扫描过程中，右边的都应该大于未排序范围内最大的那个
 * 以此来确定最短的待排序区间
 *
 */
public class ShortestUnsortedContinuousSubarray {
    public static int findUnsortedSubarray(int[] nums) {
        int begin = -1, end = -2, n = nums.length;
        int max = nums[0], min = nums[n - 1];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[n - i - 1]);
            if (max > nums[i]) end = i;
            if (min < nums[n - i - 1]) begin = n - i - 1;
        }
        return end - begin + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,4,2};
        System.out.println(findUnsortedSubarray(nums));

    }
}
