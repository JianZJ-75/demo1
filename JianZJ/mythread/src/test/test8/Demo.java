package test.test8;

/**
 * @Author JianZJ
 * @Date 2024/6/13 18:44
 */
public class Demo {
    public static void main(String[] args) throws InterruptedException {
        MyThread t = new MyThread();
        t.setName("土豆");
        t.start();

        t.join();

        for (int i = 0; i < 10; i++) {
            System.out.println("main @ " + i);
        }
    }
}