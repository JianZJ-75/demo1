package Jun_2024;

/**
 * @Author JianZJ
 * @Date 2024/6/11 17:50
 */
public class Solution_2024_6_11 {
    public int countBattleships(char[][] board) {
        int ans = 0;
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (board[i][j] == 'X' && (i + 1 >= n || board[i + 1][j] == '.') && (j + 1 >= m || board[i][j + 1] == '.'))
                    ans++;
        return ans;
    }
}