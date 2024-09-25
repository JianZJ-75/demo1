package Sept_2024;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author JianZJ
 * @Date 2024/9/25 19:50
 */
public class Solution_2024_9_25 {
    // TODO
    public long distinctNames(String[] ideas) {
        Set<String>[] groups = new HashSet[26];
        Arrays.setAll(groups, i -> new HashSet<>());
        for (String s : ideas) {
            groups[s.charAt(0) - 'a'].add(s.substring(1)); // 按照首字母分组
        }

        long ans = 0;
        for (int a = 1; a < 26; a++) { // 枚举所有组对
            for (int b = 0; b < a; b++) {
                int m = 0; // 交集的大小
                for (String s : groups[a]) {
                    if (groups[b].contains(s)) {
                        m++;
                    }
                }
                ans += (long) (groups[a].size() - m) * (groups[b].size() - m);
            }
        }
        return ans * 2; // 乘 2 放到最后
    }
}