package July_2024;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/7/30 20:07
 */
public class Solution_2024_7_30 {

    private int qmi(int a, int b, int m) {
        int res = 1;
        while (b > 0) {
            if ((b & 1) == 1)
                res = res * a % m;
            a = a * a % m;
            b /= 2;
        }
        return res;
    }

    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < variables.length; i++) {
            int a = variables[i][0];
            int b = variables[i][1];
            int c = variables[i][2];
            int m = variables[i][3];
            int tmp = qmi(a, b, 10);
            if (qmi(tmp, c, m) == target)
                res.add(i);
        }
        return res;
    }
}