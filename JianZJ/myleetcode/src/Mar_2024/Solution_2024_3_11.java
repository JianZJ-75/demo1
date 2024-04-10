package Mar_2024;

/**
 * @Author JianZJ
 * @Date 2024/3/11 12:17
 */
public class Solution_2024_3_11 {
    public String capitalizeTitle1(String title) {
        title = title.toLowerCase();
        int n = title.length();
        for (int i = 0; i < n;) {
            if (title.charAt(i) == ' ') {
                i++;
                continue;
            }
            int j = i;
            int len = 0;
            while (j < n && title.charAt(j) != ' ') {
                j++;
                len++;
            }
            if (len > 2) {
                char t = (char) (title.charAt(i) - 32);
                title = title.substring(0, i) + t + title.substring(i + 1, n);
            }
            i = j;
        }
        return title;
    }

    public String capitalizeTitle2(String title) {
        StringBuilder res = new StringBuilder();
        // 将title按照字符" "分割
        for (var s : title.split(" ")) {
            if (res.length() != 0)
                res.append(" ");
            if (s.length() > 2) {
                res.append(s.substring(0, 1).toUpperCase());
                s = s.substring(1);
            }
            res.append(s.toLowerCase());
        }
        return res.toString();
    }
}
