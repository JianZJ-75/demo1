package test.pool2;

/**
 * @Author JianZJ
 * @Date 2024/6/14 19:20
 */
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "@" + i);
        }
    }
}