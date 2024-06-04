package doudizhu3;

import java.util.*;

/**
 * @Author JianZJ
 * @Date 2024/6/5 0:14
 */
public class PokerGame {

    static Map<String, Integer> mp = new HashMap<>();
    static List<String> list = new ArrayList<>();

    static {
        // 准备牌
        String[] color = {"♦", "♣", "♥", "♠"};
        String[] number = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        int serialNumber = 0;
        for (String i : number) {
            for (String j : color) {
                mp.put(j + i, ++serialNumber);
                list.add(j + i);
            }
        }
        mp.put("小王", ++serialNumber);
        mp.put("大王", ++serialNumber);
        list.add("小王");
        list.add("大王");
    }

    public PokerGame() {
        // 洗牌
        Collections.shuffle(list);
        // 发牌
        TreeSet<String> lord = new TreeSet<>((o1, o2) -> mp.get(o1) - mp.get(o2));
        TreeSet<String> player1 = new TreeSet<>((o1, o2) -> mp.get(o1) - mp.get(o2));
        TreeSet<String> player2 = new TreeSet<>((o1, o2) -> mp.get(o1) - mp.get(o2));
        TreeSet<String> player3 = new TreeSet<>((o1, o2) -> mp.get(o1) - mp.get(o2));
        for (int i = 0; i < list.size(); i++) {
            String tmp = list.get(i);
            if (i < 3) {
                lord.add(tmp);
                continue;
            }
            if (i % 3 == 0)
                player1.add(tmp);
            else if (i % 3 == 1)
                player2.add(tmp);
            else
                player3.add(tmp);
        }
        // 看牌
        lookPoker("底牌", lord);
        lookPoker("player1", player1);
        lookPoker("player2", player2);
        lookPoker("player3", player3);
    }

    public void lookPoker(String name, TreeSet<String> ts) {
        System.out.println(name + " : ");
        for (String poker : ts) {
            System.out.print(poker + " ");
        }
        System.out.println();
    }

}
