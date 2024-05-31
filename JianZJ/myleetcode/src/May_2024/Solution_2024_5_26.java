package May_2024;

import java.util.Arrays;

/**
 * @Author JianZJ
 * @Date 2024/5/31 21:31
 */
public class Solution_2024_5_26 {
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] a = new int[m * n];
        int idx = 0;
        int[][] pre = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pre[i + 1][j + 1] = pre[i][j + 1] ^ pre[i + 1][j] ^ pre[i][j] ^ matrix[i][j];
                a[idx++] = pre[i + 1][j + 1];
            }
        }
        Arrays.sort(a);
        return a[idx - k];
    }
}
