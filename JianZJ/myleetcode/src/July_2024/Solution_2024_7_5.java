package July_2024;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/7/5 19:19
 */
public class Solution_2024_7_5 {
    public int[][] modifiedMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] res = new int[n][m];
        for (int j = 0; j < m; j++) {
            int max = -1;
            List<Integer> pos = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                max = Math.max(max, matrix[i][j]);
                res[i][j] = matrix[i][j];
                if (matrix[i][j] == -1) {
                    pos.add(i);
                }
            }
            for (Integer po : pos) {
                res[po][j] = max;
            }
        }
        return res;
    }
}