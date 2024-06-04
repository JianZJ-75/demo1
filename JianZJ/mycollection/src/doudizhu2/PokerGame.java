package doudizhu2;

import java.util.*;

/**
 * @Author JianZJ
 * @Date 2024/6/4 23:49
 */
public class PokerGame {

    static Map<Integer, String> mp = new HashMap<>();
    static List<Integer> list = new ArrayList<>();

    static {
        // 准备牌
        String[] color = {"♦", "♣", "♥", "♠"};
        String[] number = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        int serialNumber = 0;
        for (String i : number) {
            for (String j : color) {
                mp.put(++serialNumber, j + i);
                list.add(serialNumber);
            }
        }
        mp.put(++serialNumber, "小王");
        list.add(serialNumber);
        mp.put(++serialNumber, "大王");
        list.add(serialNumber);
    }

    public PokerGame() {
        // 洗牌
        Collections.shuffle(list);
        // 发牌
        TreeSet<Integer> lord = new TreeSet<>();
        TreeSet<Integer> player1 = new TreeSet<>();
        TreeSet<Integer> player2 = new TreeSet<>();
        TreeSet<Integer> player3 = new TreeSet<>();
        for (int i = 0; i < list.size(); i++) {
            int tmp = list.get(i);
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

    public void lookPoker(String name, TreeSet<Integer> ts) {
        System.out.println(name + " : ");
        for (Integer poker : ts) {
            System.out.print(mp.get(poker) + " ");
        }
        System.out.println();
    }

}
