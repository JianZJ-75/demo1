package May_2024;

/**
 * @Author JianZJ
 * @Date 2024/5/8 13:29
 */
public class Solution_2024_5_8 {
    public int wateringPlants(int[] plants, int capacity) {
        int ans = 0;
        int now = capacity;
        int n = plants.length;
        for (int i = 0; i < n; i++) {
            if (now >= plants[i]) {
                now -= plants[i];
                ans++;
            } else {
                ans += i + i + 1;
                now = capacity - plants[i];
            }
        }
        return ans;
    }
}
