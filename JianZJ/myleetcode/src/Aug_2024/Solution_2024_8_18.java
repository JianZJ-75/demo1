package Aug_2024;

/**
 * @Author JianZJ
 * @Date 2024/8/18 19:47
 */
public class Solution_2024_8_18 {
    public boolean checkRecord(String s) {
        int n = s.length();
        int cnt = 0;
        for (int i = 0; i < n;) {
            int j = i;
            int len = 0;
            while (j < n && s.charAt(j) == s.charAt(i)) {
                j++;
                len++;
            }
            if (s.charAt(i) == 'A') {
                cnt += len;
            } else if (s.charAt(i) == 'L') {
                if (len >= 3) {
                    return false;
                }
            }
            i = j;
        }
        return cnt < 2 ? true : false;
    }
}