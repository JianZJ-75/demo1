package Apr_2024;

import java.util.Arrays;
import java.util.Collections;

/**
 * @Author JianZJ
 * @Date 2024/4/22 16:27
 */
public class Solution_2024_4_22 {
    public int combinationSum4(int[] nums, int target) {
        int[] temp = new int[target + 1];
        Arrays.setAll(temp, i -> -1);
        return dfs(target, nums, temp);
    }

    private int dfs(int target, int[] nums, int[] temp) {
        if (target == 0) {
            return 1;
        }
        if (temp[target] != -1) {
            return temp[target];
        }
        int res = 0;
        for (int num : nums) {
            if (num <= target) {
                res += dfs(target - num, nums, temp);
            }
        }
        return temp[target] = res;
    }
}
