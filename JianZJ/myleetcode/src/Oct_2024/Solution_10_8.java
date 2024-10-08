package Oct_2024;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author JianZJ
 * @Date 2024/10/8 22:24
 */
public class Solution_10_8 {
    public String destCity(List<List<String>> paths) {
        Map<String, Integer> map = new HashMap<>();
        for (List<String> path : paths) {
            String from = path.get(0);
            String to = path.get(1);
            map.put(from, map.getOrDefault(from, 0) + 1);
            map.put(to, map.getOrDefault(to, 0) - 1);
        }
        String ans = "";
        for (String key : map.keySet()) {
            if (map.get(key) == -1) {
                ans = key;
                break;
            }
        }
        return ans;
    }
}