package test.test5;

/**
 * @Author JianZJ
 * @Date 2024/6/11 22:12
 */
public class Demo {
    public static void main(String[] args) {
        MyRunnable r1 = new MyRunnable();

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r1);

        t1.setPriority(1);
        t2.setPriority(10);

        t1.start();
        t2.start();

        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());
        System.out.println(Thread.currentThread().getPriority());

    }
}