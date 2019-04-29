package LeetCode100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * 560. Subarray Sum Equals K
 *
 * 1.暴力，2个for循环
 * 2.HashMap：
 * 对于2个连续子串
 * a1,a2,...ak1
 * a1,a2,...ak1,ak2...akk
 * 如果他们的和相等，那么表示ak2+ak3+...+akk = 0,因此如果sum2 - sum1 = k，那么有ak2+ak3...+akk = k,即找到了1个和为k的连续子串
 *
 */
public class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
//        int n = nums.length;
//        int count = 0;
//        for (int i = 0; i < n; i++) {
//            int sum = 0;
//            for (int j = i; j < n; j++) {
//                sum += nums[j];
//                if (sum == k) count++;
//            }
//        }
//        return count;

        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int count = 0;
        int sum = 0;
        map.put(0, 1);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            // 注意这里是count += map.get(sum - k)
            if (map.containsKey(sum - k)) count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,0,0,0,0,0,0,0,0};
        int i = subarraySum(nums, 0);
        System.out.println(i);
    }
}
