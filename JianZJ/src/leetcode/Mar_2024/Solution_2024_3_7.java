package leetcode.Mar_2024;

/**
 * @Author JianZJ
 * @Date 2024/3/7 21:04
 */
public class Solution_2024_3_7 {
    public int[] divisibilityArray(String word, int m) {
        int n = word.length();
        int[] res = new int[n];
        long k = 0;
        for (int i = 0; i < n; i++) {
            k = k * 10 + (int) (word.charAt(i) - '0');
            res[i] = k % m == 0 ? 1 : 0;
            k %= m;
        }
        return res;
    }
}
