package Mar_2024;

/**
 * @Author JianZJ
 * @Date 2024/3/13 17:36
 */
public class Solution_2024_3_13 {
    public String maximumOddBinaryNumber(String s) {
        String res = new String();
        int n = s.length();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1')
                cnt++;
        }
        for (int i = 1; i < cnt; i++)
            res += '1';
        for (int i = 1; i <= n - cnt; i++)
            res += '0';
        res += '1';
        return res;
    }
}
