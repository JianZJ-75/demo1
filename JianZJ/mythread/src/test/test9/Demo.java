package test.test9;

/**
 * @Author JianZJ
 * @Date 2024/6/13 18:51
 */
public class Demo {
    public static void main(String[] args) {
//        MyRunnable mr = new MyRunnable();
//        Thread t1 = new Thread(mr, "窗口1");
//        Thread t2 = new Thread(mr, "窗口2");
//        Thread t3 = new Thread(mr, "窗口3");
//
//        t1.start();
//        t2.start();
//        t3.start();

        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}