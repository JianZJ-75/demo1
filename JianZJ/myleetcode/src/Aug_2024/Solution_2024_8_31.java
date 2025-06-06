package Aug_2024;

/**
 * @Author JianZJ
 * @Date 2024/8/31 22:25
 */
public class Solution_2024_8_31 {
    public boolean canMakeSquare(char[][] grid) {
        return check(grid, 0, 0) || check(grid, 0, 1) || check(grid, 1, 0) || check(grid, 1, 1);
    }

    private boolean check(char[][] grid, int i, int j) {
        int cnt = 0;
        if (grid[i][j] == 'B') {
            cnt++;
        }
        if (grid[i + 1][j] == 'B') {
            cnt++;
        }
        if (grid[i][j + 1] == 'B') {
            cnt++;
        }
        if (grid[i + 1][j + 1] == 'B') {
            cnt++;
        }
        return cnt != 2;
    }
}