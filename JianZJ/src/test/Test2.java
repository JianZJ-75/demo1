package test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;

/**
 * @Author: JianZJ
 * @Date: 2024/1/2 23:04
 */
public class Test2 {
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++)
            dp[i] = Integer.MAX_VALUE;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String i : dictionary)
            map.put(i, 1);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = i - 1; j >= 0; j--) {
                if (map.containsKey(s.substring(j, i)))
                    dp[i] = Math.min(dp[i], dp[j]);
            }
        }
        return dp[n];
    }
    public int minLength(String s) {
        int n = s.length();
        char[] stk = new char[n + 1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (index > 0)
            {
                if (s.charAt(i) == 'B' && stk[index] == 'A')
                    index--;
                else if (s.charAt(i) == 'D' && stk[index] == 'C')
                    index--;
                else
                    stk[++index] = s.charAt(i);
            }else
                stk[++index] = s.charAt(i);
        }
        return index;
    }
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getByName("CY");
        System.out.println(address);
        System.out.println(address.getHostAddress());
        System.out.println(address.getHostName());
    }
}
