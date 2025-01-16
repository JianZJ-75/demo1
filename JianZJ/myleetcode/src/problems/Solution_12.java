package problems;

/**
 * @Author JianZJ
 * @Date 2025/1/11 17:51
 */
public class Solution_12 {

    public String intToRoman(int num) {
        String ans = "";
        int ok = 1;
        String[] st = {"I", "V", "X", "L", "C", "D", "M"};
        while (num > 0) {
            if (ok == 7)
                break;
            String t = "";
            int tmp = num % 10;
            num /= 10;
            if (tmp == 4) {
                t = st[ok - 1] + st[ok] + t;
            } else if (tmp == 9) {
                t = st[ok - 1] + st[ok + 1] + t;
            } else {
                if (tmp >= 5) {
                    tmp -= 5;
                    t = st[ok] + t;
                }
                while (tmp != 0) {
                    tmp--;
                    t = t + st[ok - 1];
                }
            }
            ans = t + ans;
            ok += 2;
        }
        while (num > 0) {
            ans = "M" + ans;
            num--;
        }
        return ans;
    }

}