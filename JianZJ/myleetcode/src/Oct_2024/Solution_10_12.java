package Oct_2024;

/**
 * @Author JianZJ
 * @Date 2024/10/12 19:30
 */
public class Solution_10_12 {
    public int duplicateNumbersXOR(int[] nums) {
        boolean pos[] = new boolean[51];
        int ans = 0;
        for (int x : nums) {
            if (pos[x]) {
                ans ^= x;
            } else {
                pos[x] = true;
            }
        }
        return ans ^ 0;
    }
}