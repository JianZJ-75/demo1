package test.pool2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author JianZJ
 * @Date 2024/6/14 19:19
 */
public class Demo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool1 = Executors.newCachedThreadPool();
        ExecutorService pool2 = Executors.newFixedThreadPool(3);

        pool1.submit(new MyRunnable());
        Thread.sleep(2000);
        pool1.submit(new MyRunnable());

        pool2.submit(new MyRunnable());
        Thread.sleep(10000);
        pool2.submit(new MyRunnable());

        pool1.shutdown();
        pool2.shutdown();
    }
}