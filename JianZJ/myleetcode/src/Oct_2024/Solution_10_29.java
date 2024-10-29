package Oct_2024;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/10/29 23:14
 */
public class Solution_10_29 {
    // TODO
    public List<String> validStrings(int n) {
        List<String> ans = new ArrayList<>();
        char[] path = new char[n];
        dfs(0, n, path, ans);
        return ans;
    }

    private void dfs(int i, int n, char[] path, List<String> ans) {
        if (i == n) {
            ans.add(new String(path));
            return;
        }

        // 填 1
        path[i] = '1';
        dfs(i + 1, n, path, ans);

        // 填 0
        if (i == 0 || path[i - 1] == '1') {
            path[i] = '0'; // 直接覆盖
            dfs(i + 1, n, path, ans);
        }
    }
}