package LeetCode100;

public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        int i, j;
        for (i = nums.length - 1; i >= 0; i--) {
            if (i == 0) {
                reverse(nums, 0);
                return;
            }
            if (nums[i - 1] < nums[i]) {
                break;
            }
        }
        int L = i - 1;
        for (j = nums.length - 1; j > L; j--) {
            if (nums[j] > nums[L]) {
                break;
            }
        }
        int R = j;
        swap(nums, L, R);
        reverse(nums, L + 1);
    }

    public static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        nextPermutation(new int[]{5,4,7,5,3,2});
    }
}
