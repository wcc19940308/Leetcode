package LeetCode100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            if(i>0 && nums[i]==nums[i-1])
                continue;
            int lo = i + 1, hi = len - 1;
            while (lo < hi) {
                if (nums[i] + nums[lo] + nums[hi] == 0) {
                    //if(!list.contains(Arrays.asList(nums[i], nums[lo], nums[hi])))
                        list.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    while(lo<hi && nums[lo]==nums[lo+1]) lo++;
                    while(lo<hi && nums[hi]==nums[hi-1]) hi--;
                    lo++;hi--;
                } else if (nums[i] + nums[lo] + nums[hi] < 0) {
                    lo++;
                } else {
                    hi--;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}
