package test.test6;

/**
 * @Author JianZJ
 * @Date 2024/6/11 22:17
 */
public class Demo {
    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1();
        MyThread2 t2 = new MyThread2();

        t1.setName("女神");
        t2.setName("备胎");

        // 设置为守护线程(备胎线程)
        t2.setDaemon(true);

        t1.start();
        t2.start();
    }
}