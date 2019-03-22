package LeetCode100;

public class ClimbingStairs {
    public static int climbStairs(int n) {
        if(n==1)
            return 1;
        int s1 = 1;
        int s2 = 1;
        int tmp;
        for (int i = 2; i <= n; i++) {
            tmp = s2;
            s2 = s1 + s2;
            s1 = tmp;

        }
        return s2;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));

    }
}
