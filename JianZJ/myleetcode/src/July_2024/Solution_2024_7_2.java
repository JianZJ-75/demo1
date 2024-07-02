package July_2024;

/**
 * @Author JianZJ
 * @Date 2024/7/2 16:37
 */
public class Solution_2024_7_2 {
    private static final int MX = 101;
    private static final boolean[] pos = new boolean[MX];

    static {
        pos[1] = true;
        for (int i = 2; i * i < MX; i++) {
            if (pos[i])
                continue;
            for (int j = i * i; j < MX; j += i) {
                pos[j] = true;
            }
        }
    }

    public int maximumPrimeDifference(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (pos[nums[l]])
            l++;
        while (pos[nums[r]])
            r--;
        return Math.max(0, r - l);
    }
}