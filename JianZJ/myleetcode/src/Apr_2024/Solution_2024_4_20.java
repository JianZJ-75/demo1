package Apr_2024;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/4/20 17:20
 */
public class Solution_2024_4_20 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(0, target, candidates, ans, path);
        return ans;
    }

    private void dfs(int i, int target, int[] candidates, List<List<Integer>> ans, List<Integer> path) {
        if (target == 0)
        {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (i == candidates.length || target < 0) {
            return;
        }
        dfs(i + 1, target, candidates, ans, path);
        path.add(candidates[i]);
        dfs(i, target - candidates[i], candidates, ans, path);
        path.remove(path.size() - 1);
    }

}
