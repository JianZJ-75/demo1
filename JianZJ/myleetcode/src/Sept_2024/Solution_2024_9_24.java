package Sept_2024;

/**
 * @Author JianZJ
 * @Date 2024/9/24 21:41
 */
public class Solution_2024_9_24 {
    public long maximumSubsequenceCount(String text, String pattern) {
        long ans = 0;
        char x = pattern.charAt(0);
        char y = pattern.charAt(1);
        int cntX = 0, cntY = 0;
        for (int i = 0; i < text.length(); i++) {
            char t = text.charAt(i);
            if (t == y) {
                ans += cntX;
                cntY++;
            }
            if (t == x) {
                cntX++;
            }
        }
        return ans + Math.max(cntX, cntY);
    }
}