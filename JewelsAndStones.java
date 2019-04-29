package LeetCode100;

public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            if (J.contains(S.substring(i, i + 1))) {
                count++;
            }
        }
        return count;
    }
}
