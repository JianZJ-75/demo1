package Sept_2024;

import java.util.*;

/**
 * @Author JianZJ
 * @Date 2024/9/17 20:37
 */
public class Solution_2024_9_17 {
    // TODO
    public int numBusesToDestination(int[][] routes, int source, int target) {
        // 记录经过车站 x 的公交车编号
        Map<Integer, List<Integer>> stopToBuses = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int x : routes[i]) {
                stopToBuses.computeIfAbsent(x, k -> new ArrayList<>()).add(i);
            }
        }

        // 小优化：如果没有公交车经过起点或终点，直接返回
        if (!stopToBuses.containsKey(source) || !stopToBuses.containsKey(target)) {
            // 注意原地 TP 的情况
            return source != target ? -1 : 0;
        }

        // BFS
        Map<Integer, Integer> dis = new HashMap<>();
        dis.put(source, 0);
        Queue<Integer> q = new ArrayDeque<>();
        q.add(source);
        while (!q.isEmpty()) {
            int x = q.poll(); // 当前在车站 x
            int disX = dis.get(x);
            for (int i : stopToBuses.get(x)) { // 遍历所有经过车站 x 的公交车 i
                if (routes[i] != null) {
                    for (int y : routes[i]) { // 遍历公交车 i 的路线
                        if (!dis.containsKey(y)) { // 没有访问过车站 y
                            dis.put(y, disX + 1); // 从 x 站上车然后在 y 站下车
                            q.add(y);
                        }
                    }
                    routes[i] = null; // 标记 routes[i] 遍历过
                }
            }
        }

        return dis.getOrDefault(target, -1);
    }
}