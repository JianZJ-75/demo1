package July_2024;

import java.util.*;

/**
 * @Author JianZJ
 * @Date 2024/7/24 12:51
 */
public class Solution_2024_7_24 {
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        int n = nums.length;
        HashSet<Integer> set  = new HashSet<>(n);
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 0; i < moveFrom.length; i++) {
            set.remove(moveFrom[i]);
            set.add(moveTo[i]);
        }
        List<Integer> res = new ArrayList<>(set);
        Collections.sort(res);
        return res;
    }
}