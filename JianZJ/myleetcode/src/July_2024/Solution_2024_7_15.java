package July_2024;

import java.util.*;

/**
 * @Author JianZJ
 * @Date 2024/7/15 23:19
 */
public class Solution_2024_7_15 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<Integer>> idx = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                idx.computeIfAbsent(accounts.get(i).get(j), k -> new ArrayList<>()).add(i);
            }
        }
        List<List<String>> res = new ArrayList<>();
        boolean[] vis = new boolean[accounts.size()];
        for (int i = 0; i < accounts.size(); i++) {
            if (vis[i])
                continue;
            List<String> tmp = new ArrayList<>();
            dfs(i, accounts, idx, vis, tmp);
            System.out.println(tmp);
            Collections.sort(tmp);
            tmp.add(0, accounts.get(i).get(0));
            res.add(tmp);
        }
        return res;
    }

    private void dfs(int now, List<List<String>> accounts, Map<String, List<Integer>> idx, boolean[] vis, List<String> res) {
        for (int i = 1; i < accounts.get(now).size(); i++) {
            vis[now] = true;
            String tmp = accounts.get(now).get(i);
            if (res.contains(tmp))
                continue;
            res.add(tmp);
            for (Integer integer : idx.get(tmp)) {
                if (vis[integer])
                    continue;
                dfs(integer, accounts, idx, vis, res);
            }
        }
    }
}