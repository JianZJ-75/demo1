package Oct_2024;

/**
 * @Author JianZJ
 * @Date 2024/10/19 23:06
 */
public class Solution_10_19 {
    // TODO
    public int minOperations(int[] nums) {
        int k = 0;
        for (int x : nums) {
            if (x == k % 2) { // 必须操作
                k++;
            }
        }
        return k;
    }
}