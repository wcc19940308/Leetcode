package LeetCode100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// 1、第一轮将每个数字对应的那个位置的数字变成负值（因为所有数都是正的，这么做不影响后续）
// 2、第二轮，统计那些没有变成负值的，这些就是没有出现过的数
public class FindAllNumberDisappearedinanArray {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <nums.length ; i++) {
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0)
                nums[val] = -nums[val];
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) list.add(i + 1);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}).toString());
    }
}
