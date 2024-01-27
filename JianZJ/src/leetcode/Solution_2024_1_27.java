package leetcode;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: JianZJ
 * @Date: 2024/1/27 13:29
 */
public class Solution_2024_1_27 {
    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        int[] s = stock.stream().mapToInt(i -> i).toArray();
        int[] c = cost.stream().mapToInt(i -> i).toArray();
        int ans = 0;
        for (List<Integer> com : composition) {
            int[] t = com.stream().mapToInt(i -> i).toArray();
            int l = -1;
            int r = Collections.min(stock) + budget + 10;
            while (r - l > 1) {
                int mid = (l + r) / 2;
                if (check(mid, n, budget, t, s, c))
                    l = mid;
                else
                    r = mid;
            }
            ans = Math.max(ans, l);
        }
        return ans;
    }
    public boolean check(int mid, int n, int budget, int[] t, int[] s, int[] c) {
        long sum = 0;
        for (int i = 0; i < n; i++) {
            long num = (long)mid * t[i];
            if (num > s[i])
                sum += (num - s[i]) * c[i];
        }
        if (sum <= budget)
            return true;
        else
            return false;
    }
}
