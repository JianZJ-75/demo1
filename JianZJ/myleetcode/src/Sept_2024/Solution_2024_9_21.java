package Sept_2024;

/**
 * @Author JianZJ
 * @Date 2024/9/21 22:37
 */
public class Solution_2024_9_21 {
    // TODO
    public int edgeScore(int[] edges) {
        int ans = 0;
        long[] score = new long[edges.length];
        for (int i = 0; i < edges.length; i++) {
            int to = edges[i];
            score[to] += i;
            if (score[to] > score[ans] || score[to] == score[ans] && to < ans) {
                ans = to;
            }
        }
        return ans;
    }
}