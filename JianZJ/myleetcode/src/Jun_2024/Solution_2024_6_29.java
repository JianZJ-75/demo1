package Jun_2024;

/**
 * @Author JianZJ
 * @Date 2024/6/29 22:42
 */
public class Solution_2024_6_29 {
    public String removeTrailingZeros(String num) {
        int n = num.length();
        int idx = n;
        for (; idx > 0; idx--) {
            if (num.charAt(idx - 1) != '0') {
                break;
            }
        }
        return num.substring(0, idx);
    }
}