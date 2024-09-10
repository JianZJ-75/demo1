package Sept_2024;

/**
 * @Author JianZJ
 * @Date 2024/9/10 21:13
 */
public class Solution_2024_9_10 {
    public long countQuadruplets(int[] nums) {
        long ans = 0;
        int n = nums.length;
        long cnt3[] = new long[n];
        for (int l = 2; l < n; l++) {
            long cnt2 = 0;
            for(int j = 0; j < l; j++) {
                if (nums[j] < nums[l]) {
                    ans += cnt3[j];
                    cnt2++;
                } else {
                    cnt3[j] += cnt2;
                }
            }
        }
        return ans;
    }
}