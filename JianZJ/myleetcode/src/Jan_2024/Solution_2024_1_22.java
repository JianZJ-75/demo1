package Jan_2024;

import java.util.*;

/**
 * @Author: JianZJ
 * @Date: 2024/1/22 10:30
 */
public class Solution_2024_1_22 {
    public int maximumSwap(int num) {
        List<Integer> a = new ArrayList<>();
        for (int i = num; i > 0; i /= 10)
            a.add(i % 10);
        int n = a.size();
        for (int i = n - 1; i >= 0; i--) {
            int j = i;
            for (int u = 0; u < i; u++)
                if (a.get(u) > a.get(j))
                    j = u;
            if (i == j)
                continue;
            Collections.swap(a, i, j);
            break;
        }
        int res = 0;
        for (int i = n - 1; i >= 0; i--)
            res = res * 10 + a.get(i);
        return res;
    }
}
