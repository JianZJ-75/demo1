package Oct_2024;

/**
 * @Author JianZJ
 * @Date 2024/10/15 21:23
 */
public class Solution_10_15 {
    // TODO
    public int maxHeightOfTriangle(int red, int blue) {
        int[] cnt = new int[2];
        for (int i = 1; ; i++) {
            cnt[i % 2] += i;
            if ((cnt[0] > red || cnt[1] > blue) && (cnt[0] > blue || cnt[1] > red)) {
                return i - 1;
            }
        }
    }
}