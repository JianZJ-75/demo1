package doudizhu.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CodeUtil {

    static List<Character> list = new ArrayList<>();

    static {
        for (int i = 0; i < 26; i++) {
            list.add((char)('a' + i));
            list.add((char)('A' + i));
        }
    }

    public static String getCode(){
        List<Character> tmp = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 4; i++)
            tmp.add(list.get(r.nextInt(list.size())));
        tmp.add((char)r.nextInt(10));
        tmp.add((char)r.nextInt(10));
        Collections.shuffle(tmp);
        String ans = "";
        for (Character i : tmp) {
            ans += i;
        }
        return ans;
    }
}