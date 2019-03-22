package LeetCode100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// 1����һ�ֽ�ÿ�����ֶ�Ӧ���Ǹ�λ�õ����ֱ�ɸ�ֵ����Ϊ�������������ģ���ô����Ӱ�������
// 2���ڶ��֣�ͳ����Щû�б�ɸ�ֵ�ģ���Щ����û�г��ֹ�����
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
