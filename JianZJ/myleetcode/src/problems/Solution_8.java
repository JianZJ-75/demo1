package problems;

/**
 * @Author JianZJ
 * @Date 2025/1/11 17:14
 */
public class Solution_8 {

    public int myAtoi(String s) {
        long ans = 0;
        int ok = 1;
        int flag = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ' && ok == 1) {
                continue;
            }
            if (c == '+' && ok == 1) {
                ok++;
                continue;
            } else if (c == '-' && ok == 1) {
                flag = -1;
                ok++;
                continue;
            }
            if (c >= '0' && c <= '9' && (ok == 2 || ok == 1)) {
                ans = ans * 10 + (c - '0');
                ok = 2;
                if (ans > Integer.MAX_VALUE) {
                    break;
                }
                continue;
            }
            break;
        }
        ans *= flag;
        ans = Math.min(Integer.MAX_VALUE, ans);
        ans = Math.max(Integer.MIN_VALUE, ans);
        return (int) ans;
    }

}