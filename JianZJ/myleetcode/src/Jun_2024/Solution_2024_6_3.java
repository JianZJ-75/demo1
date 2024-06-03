package Jun_2024;

/**
 * @Author JianZJ
 * @Date 2024/6/3 16:01
 */
public class Solution_2024_6_3 {
    public int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];
        // 要写8.0不能写8, 否则会爆int
        int m = (int) ((Math.sqrt(1.0 + 8.0 * candies) - 1) / 2);
        int k = m / num_people, s = m % num_people;
        for (int i = 0; i < num_people; i++) {
            ans[i] = k * (k - 1) / 2 * num_people + k * (i + 1) + (i < s ? k * num_people + i + 1 : 0);
        }
        ans[s] += candies - m * (m + 1) / 2;
        return ans;
    }
}
