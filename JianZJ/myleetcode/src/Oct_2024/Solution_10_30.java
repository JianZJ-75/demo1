package Oct_2024;

/**
 * @Author JianZJ
 * @Date 2024/10/30 21:35
 */
public class Solution_10_30 {
    // TODO
    public String getSmallestString(String s) {
        char[] t = s.toCharArray();
        for (int i = 1; i < t.length; i++) {
            char x = t[i - 1];
            char y = t[i];
            if (x > y && x % 2 == y % 2) {
                t[i - 1] = y;
                t[i] = x;
                break;
            }
        }
        return new String(t);
    }
}