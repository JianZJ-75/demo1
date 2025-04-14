package chain.test1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author JianZJ
 * @Date 2025/4/14 19:53
 */
public class Test1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        s = s.split("\\?")[1];
        Map<String, String> mp = new HashMap<String, String>();
        for (String string : s.split("&")) {
            String[] split = string.split("=");
            mp.put(split[0], split[1]);
        }
        System.out.println(mp.get(t));
    }

}