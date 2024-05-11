package May_2024;

/**
 * @Author JianZJ
 * @Date 2024/5/11 12:43
 */
public class Solution_2024_5_11 {
    public int garbageCollection(String[] garbage, int[] travel) {
        int m_t = 0, p_t = 0, g_t = 0;
        int m_now = 0, p_now = 0, g_now = 0;
        int n = garbage.length;
        for (int i = 0; i < n; i++) {
            String s = garbage[i];
            int len = s.length();
            for (int j = 0; j < len; j++) {
                if (s.charAt(j) == 'M') {
                    m_now = m_now + m_t + 1;
                    m_t = 0;
                } else if (s.charAt(j) == 'P') {
                    p_now = p_now + p_t + 1;
                    p_t = 0;
                } else if (s.charAt(j) == 'G') {
                    g_now = g_now + g_t + 1;
                    g_t = 0;
                }
            }
            if (i == n - 1) {
                break;
            }
            m_t += travel[i];
            p_t += travel[i];
            g_t += travel[i];
        }
        return m_now + p_now + g_now;
    }
}
