package LeetCode100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        backTrack(list, tempList, nums, 0);
        return list;
    }

    public static void backTrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backTrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }



    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1,2,3}));
    }
}
