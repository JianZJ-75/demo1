package Jun_2024;

/**
 * @Author JianZJ
 * @Date 2024/6/27 17:39
 */
public class Solution_2024_6_27 {
    public String smallestString(String s) {
        char[] tmp = s.toCharArray();
        int n = tmp.length;
        int l = 0;
        while (l < n && tmp[l] == 'a')
            l++;
        if (l == n)
            l--;
        int r = l;
        while (r + 1 < n && tmp[r + 1] != 'a')
            r++;
        for (int i = l; i <= r; i++)
            if (tmp[i] == 'a')
                tmp[i] = 'z';
            else
                tmp[i]--;
        return new String(tmp);
    }
}