package doudizhu1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/6/4 20:15
 */
public class PokerGame {

    // 牌盒
    static List<String> list = new ArrayList<>();

    static {
        // 准备牌
        String[] color = {"♦", "♣", "♥", "♠"};
        String[] number = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        for (String i : color) {
            for (String j : number) {
                list.add(i + j);
            }
        }
        list.add("大王");
        list.add("小王");
    }

    public PokerGame() {
        // 洗牌
        Collections.shuffle(list);
        // 发牌
        // 底牌(地主的3张)
        List<String> lord = new ArrayList<>();
        List<String> player1 = new ArrayList<>();
        List<String> player2 = new ArrayList<>();
        List<String> player3 = new ArrayList<>();
        // 遍历
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

    public void lookPoker(String name, List<String> list) {
        System.out.println(name + " : ");
        for (String poker : list) {
            System.out.print(poker + " ");
        }
        System.out.println();
    }
}
