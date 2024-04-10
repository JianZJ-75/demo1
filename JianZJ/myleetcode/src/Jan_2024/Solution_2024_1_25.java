package Jan_2024;

import java.util.List;

/**
 * @Author: JianZJ
 * @Date: 2024/1/25 15:04
 */
public class Solution_2024_1_25 {
    public int cnt(int x) {
        int res = 0;
        while (x > 0)
        {
            res += x % 2;
            x /= 2;
        }
        return res;
    }
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int n = nums.size();
        int res = 0;
        for (int i = 0; i < n; i++)
            if (cnt(i) == k)
                res += nums.get(i);
        return res;
    }
}
