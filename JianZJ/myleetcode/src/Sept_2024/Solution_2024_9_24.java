package Sept_2024;

/**
 * @Author JianZJ
 * @Date 2024/9/24 21:41
 */
public class Solution_2024_9_24 {
    // TODO
    public long maximumSubsequenceCount(String text, String pattern) {
        char x = pattern.charAt(0);
        char y = pattern.charAt(1);
        long ans = 0;
        int cntX = 0;
        int cntY = 0;
        for (char c : text.toCharArray()) {
            if (c == y) {
                ans += cntX;
                cntY++;
            }
            if (c == x) {
                cntX++;
            }
        }
        return ans + Math.max(cntX, cntY);
    }
}