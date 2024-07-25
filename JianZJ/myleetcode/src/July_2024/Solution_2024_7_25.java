package July_2024;

/**
 * @Author JianZJ
 * @Date 2024/7/25 21:59
 */
public class Solution_2024_7_25 {
    public int minimumOperations(String num) {
        int n = num.length();
        boolean ok0 = false;
        boolean ok5 = false;
        for (int i = n - 1; i >= 0; i--) {
            char c = num.charAt(i);
            if (ok0 && (c == '0' || c == '5') || ok5 && (c == '2' || c == '7')) {
                return n - i - 2;
            }
            if (c == '0') {
                ok0 = true;
            }
            if (c == '5') {
                ok5 = true;
            }
        }
        return ok0 ? n - 1 : n;
    }
}