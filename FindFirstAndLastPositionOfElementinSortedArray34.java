package LeetCode100;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementinSortedArray34 {
    public static int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        int index = findRightIndex(nums, 0, nums.length - 1, target);
        if (index < 0 || nums[index] != target) {
            return res;
        }
        res[0] = findLeftIndex(nums, 0, nums.length - 1, target);
        res[1] = index;
        return res;
    }

    public static int findLeftIndex(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start);
            if(nums[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return start;
    }

    public static int findRightIndex(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start);
            if(nums[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        return end;
    }

    public static void main(String[] args) {
        int[] ints = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println(Arrays.toString(ints));

    }
}
