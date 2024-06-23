package Jun_2024;

/**
 * @Author JianZJ
 * @Date 2024/6/22 13:02
 */

public class Solution_2024_6_22 {
    public String smallestBeautifulString(String s, int k) {
        char[] tmp = s.toCharArray();
        int n = tmp.length;
        int i = n - 1;
        tmp[i]++;
        while (i < n) {
            if (tmp[i] - 'a' == k) {
                if (i == 0)
                    return "";
                tmp[i] = 'a';
                tmp[--i]++;
            } else if (i > 0 && tmp[i] == tmp[i - 1] || i > 1 && tmp[i] == tmp[i - 2])
                tmp[i]++;
            else
                i++;
        }
        return new String(tmp);
    }
}
