package LeetCode100;

import java.util.ArrayList;
import java.util.List;

public class CountingBits {
    public static int[] countBits(int num) {
        List<Integer> list = new ArrayList<>();
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int j = i;
            int cnt = 0;
            while (j > 0) {
                cnt += j & 1;
                j >>= 1;
            }
            res[i] = cnt;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countBits(5));
    }
}
