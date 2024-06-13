package test.test7;

/**
 * @Author JianZJ
 * @Date 2024/6/13 18:37
 */
public class Demo {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.setName("飞机");
        t2.setName("坦克");

        t1.start();
        t2.start();

    }
}