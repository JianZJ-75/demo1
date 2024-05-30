package May_2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/5/30 8:41
 */
public class Solution_2024_5_30 {
    public int maximumLength(String s) {
        char[] str = s.toCharArray();
        List<Integer>[] pos = new List[26];
        Arrays.setAll(pos, i -> new ArrayList<>());
        int ans = 0;
        int n = str.length;
        for (int i = 0; i < n;) {
            int j = i;
            int len = 0;
            while (j < n && str[j] == str[i]) {
                j++;
                len++;
            }
            pos[str[i] - 'a'].add(len);
            i = j;
        }
        for (List<Integer> tmp : pos) {
            tmp.add(0);
            tmp.add(0);
            tmp.add(0);
            Collections.sort(tmp);
            Collections.reverse(tmp);
            ans = Math.max(ans,
                    Math.max(tmp.get(0) - 2,
                            Math.max(Math.min(tmp.get(0) - 1, tmp.get(1)), tmp.get(2))));
        }
        return ans > 0 ? ans : -1;
    }
}
