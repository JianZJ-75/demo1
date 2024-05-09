package May_2024;

/**
 * @Author JianZJ
 * @Date 2024/5/9 18:34
 */
public class Solution_2024_5_9 {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int n = plants.length;
        int l = 0, r = n - 1;
        int nowa = capacityA, nowb = capacityB;
        int ans = 0;
        while (r >= l) {
            if (l == r) {
                int x = Math.max(nowa, nowb);
                if (x < plants[l]) {
                    ans++;
                }
            } else {
                if (nowa < plants[l]) {
                    ans++;
                    nowa = capacityA - plants[l];
                } else {
                    nowa -= plants[l];
                }
                if (nowb < plants[r]) {
                    ans++;
                    nowb = capacityB - plants[r];
                } else {
                    nowb -= plants[r];
                }
            }
            l++;
            r--;
        }
        return ans;
    }
}
