package Apr_2024;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/4/29 0:36
 */
public class Solution_2024_4_29 {
    public int[][] diagonalSort(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        for (int i = n - 1; i > 0; i--) {
            List<Integer> temp = new ArrayList<>();
            int x = i, y = 0;
            while (x < n && y < m) {
                temp.add(mat[x][y]);
                x++;
                y++;
            }
            x = i;
            y = 0;
            Collections.sort(temp);
            int cnt = 0;
            while (x < n && y < m) {
                mat[x][y] = temp.get(cnt);
                cnt++;
                x++;
                y++;
            }
        }
        for (int i = 0; i < m; i++) {
            List<Integer> temp = new ArrayList<>();
            int x = 0, y = i;
            while (x < n && y < m) {
                temp.add(mat[x][y]);
                x++;
                y++;
            }
            x = 0;
            y = i;
            Collections.sort(temp);
            int cnt = 0;
            while (x < n && y < m) {
                mat[x][y] = temp.get(cnt);
                cnt++;
                x++;
                y++;
            }
        }
        return mat;
    }
}
