package LeetCode100;

public class MajorityElement {
    // Ì½À×·¨
    public int majorityElement(int[] nums) {
        int count = 1;
        int target = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
            } else {
                if (--count == 0) {
                    target = nums[i];
                    count = 1;
                }
            }
        }
        return target;
    }
}
