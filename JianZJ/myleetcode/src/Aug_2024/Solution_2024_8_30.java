package Aug_2024;

import org.junit.Test;

/**
 * @Author JianZJ
 * @Date 2024/8/30 22:29
 */
public class Solution_2024_8_30 {
    public long sumDigitDifferences(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        for (int i = nums[0]; i > 0; i /= 10) {
            cnt++;
        }
        if (nums[0] == 0)
            cnt = 1;
        long ans = (long) n * (n - 1) / 2 * cnt;
        for (int t = 1; t <= cnt; t++) {
            int c[] = new int[10];
            for (int i = 0; i < n; i++) {
                c[nums[i] % 10]++;
                nums[i] /= 10;
            }
            for (int i : c) {
                ans -= (long) i * (i - 1) / 2;
            }
        }
        return ans;
    }

    @Test
    public void test() {
        System.out.println(sumDigitDifferences(new int[]{13, 23, 12}));
    }
}