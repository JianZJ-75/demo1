package July_2024;

/**
 * @Author JianZJ
 * @Date 2024/7/7 18:21
 */
public class Solution_2024_7_7 {

    private static final int[][] DIRS = {{1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}};
    private static final int N = 8;

    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        for (int[] dir : DIRS) {
            int x = rMove;
            int y = cMove;
            int len = 0;
            while (true) {
                x += dir[0];
                y += dir[1];
                if (x >= N || x < 0 || y >= N || y < 0)
                    break;
                if (board[x][y] == '.')
                    break;
                if (board[x][y] != color)
                    len++;
                if (board[x][y] == color) {
                    if (len == 0)
                        break;
                    else
                        return true;
                }
            }
        }
        return false;
    }
}