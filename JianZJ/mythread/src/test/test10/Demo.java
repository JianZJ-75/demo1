package test.test10;

/**
 * @Author JianZJ
 * @Date 2024/6/13 19:25
 */
public class Demo {
    public static void main(String[] args) {
        MyRunnable mr = new MyRunnable();
        Thread t1 = new Thread(mr, "窗口1");
        Thread t2 = new Thread(mr, "窗口2");
        Thread t3 = new Thread(mr, "窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}