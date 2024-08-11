package Aug_2024;

/**
 * @Author JianZJ
 * @Date 2024/8/11 13:34
 */
public class Solution_2024_8_11 {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int f[] = new int[m + 1];
        for (int i = 0; i < n; i++) {
            int pre = 0;
            for (int j = 0; j < m; j++) {
                int tmp = f[j + 1];
                f[j + 1] = nums1[i] == nums2[j] ? pre + 1 : Math.max(f[j + 1], f[j]);
                pre = tmp;
            }
        }
        return f[m];
    }
}