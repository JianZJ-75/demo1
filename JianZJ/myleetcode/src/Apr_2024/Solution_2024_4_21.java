package Apr_2024;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/4/21 18:33
 */
public class Solution_2024_4_21 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(1, n, ans, path, k);
        return ans;
    }

    private void dfs(int i, int target, List<List<Integer>> ans, List<Integer> path, int k) {
        if (target == 0 && path.size() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (i == 10 || target < 0 || path.size() > k) {
            return;
        }
        dfs(i + 1, target, ans, path, k);
        path.add(i);
        dfs(i + 1, target - i, ans, path, k);
        path.remove(path.size() - 1);
    }
}
