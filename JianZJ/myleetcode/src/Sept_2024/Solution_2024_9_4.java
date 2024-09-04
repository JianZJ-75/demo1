package Sept_2024;

import java.util.Collections;
import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/9/4 20:17
 */
public class Solution_2024_9_4 {
    public int countWays(List<Integer> nums) {
        Collections.sort(nums);
        int ans = nums.get(0) > 0 ? 1 : 0;
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i - 1) < i && nums.get(i) > i) {
                ans++;
            }
        }
        return ans + 1;
    }
}