package Sept_2024;

import org.junit.Test;

/**
 * @Author JianZJ
 * @Date 2024/9/16 20:13
 */
public class Solution_2024_9_16 {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int[] pre = new int[distance.length + 1];
        for (int i = 0; i < distance.length; i++) {
            pre[i + 1] = pre[i] + distance[i];
        }
        if (start > destination) {
            int tmp = start;
            start = destination;
            destination = tmp;
        }
        return Math.min(pre[start] + (pre[distance.length] - pre[destination]), pre[destination] - pre[start]);
    }

    @Test
    public void test() {
        System.out.println(distanceBetweenBusStops(new int[]{1, 2, 3, 4}, 0, 1));
    }

}