package test.practice1.test2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/6/14 18:41
 */
public class Demo {
    public static void main(String[] args) {

        List<Integer> prizePool = new ArrayList<>();
        Collections.addAll(prizePool, 10, 5, 20, 50, 100, 200, 500, 800, 2, 80, 300, 700);


        MyThread t1 = new MyThread(prizePool);
        MyThread t2 = new MyThread(prizePool);

        t1.setName("抽奖箱1");
        t2.setName("抽奖箱2");

        t1.start();
        t2.start();

    }
}