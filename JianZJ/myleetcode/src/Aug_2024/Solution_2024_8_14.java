package Aug_2024;

/**
 * @Author JianZJ
 * @Date 2024/8/14 17:26
 */
public class Solution_2024_8_14 {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] fa = new int[n];
        int[] r = new int[n];
        for (int i = 0; i < n;) {
            int j = i + 1;
            fa[i] = i;
            while (j < n && nums[j] % 2 != nums[j - 1] % 2) {
                fa[j] = i;
                j++;
            }
            r[i] = j - 1;
            i = j;
        }
        int m = queries.length;
        boolean[] ans = new boolean[m];
        for (int i = 0; i < m; i++) {
            int l = fa[queries[i][0]];
            if (queries[i][1] <= r[l]) {
                ans[i] = true;
            } else {
                ans[i] = false;
            }
        }
        return ans;
    }
}