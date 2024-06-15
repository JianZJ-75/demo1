package Jun_2024;

/**
 * @Author JianZJ
 * @Date 2024/6/16 0:38
 */
public class Solution_2024_6_16 {
    public int findLUSlength(String a, String b) {
        if (!a.equals(b))
            return Math.max(a.length(), b.length());
        return -1;
    }
}