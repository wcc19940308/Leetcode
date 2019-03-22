package LeetCode100;

import java.util.Arrays;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        int m = 0, n = len - 1;
        while (m < n) {
            int[] temp = new int[len];
            temp = matrix[m];
            matrix[m] = matrix[n];
            matrix[n] = temp;
            m++;
            n--;
        }
        System.out.println(Arrays.deepToString(matrix));
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
