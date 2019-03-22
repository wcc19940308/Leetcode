package LeetCode100;

import java.util.Arrays;

public class HouseRobber {
     //int[] mem;
    public  static int rob(int[] nums) {
//        mem = new int[nums.length];
//        Arrays.fill(mem, -1);
//        return recursive(nums, nums.length - 1);
        if (nums.length == 0) return 0;
//        mem = new int[nums.length + 1];
//        mem[0] = 0;
//        mem[1] = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            int val = nums[i];
//            mem[i + 1] = Math.max(mem[i], mem[i - 1] + val);
//        }
//        return mem[nums.length];
        int pre1 = 0;
        int pre2 = 0;
        for (int i = 0; i < nums.length; i++) {
            int tmp = pre1;
            pre1 = Math.max(pre1, pre2 + nums[i]);
            pre2 = tmp;
        }
        return pre1;
    }

//    public static int recursive(int[] nums, int i) {
//        if (i < 0) {
//            return 0;
//        }
//        if (mem[i] >= 0) {
//            return mem[i];
//        }
//        int result = Math.max(recursive(nums, i - 2) + nums[i], recursive(nums, i - 1));
//        mem[i] = result;
//        return result;
//    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 2, 3, 1}));
        System.out.println(rob(new int[]{2, 1, 1, 2}));
    }
}
