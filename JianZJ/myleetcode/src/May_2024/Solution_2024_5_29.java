package May_2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/5/29 21:31
 */
public class Solution_2024_5_29 {
    public int maximumLength(String s) {
        char[] str = s.toCharArray();
        int n = str.length;
        List<Integer>[] tmp = new List[26];
        Arrays.setAll(tmp, i -> new ArrayList<>());
        for (int i = 0; i < n;) {
            int j = i;
            int len = 0;
            while (j < n && str[j] == str[i]) {
                len++;
                j++;
            }
            tmp[str[i] - 'a'].add(len);
            i = j;
        }
        int ans = 0;
        for (List<Integer> list : tmp) {
            list.add(0);
            list.add(0);
            list.add(0);
            Collections.sort(list);
            Collections.reverse(list);
            ans = Math.max(ans,
                    Math.max(list.get(0) - 2,
                            Math.max(Math.min(list.get(0) - 1, list.get(1)), list.get(2))));
        }
        return ans > 0 ? ans : -1;
    }
}
