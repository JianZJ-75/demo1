package test.pool1;

import java.util.concurrent.*;

/**
 * @Author JianZJ
 * @Date 2024/6/14 17:38
 */
public class Demo {

    static final int MAX_TURN = 5;
    private static ExecutorService pool = Executors.newFixedThreadPool(3);

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < MAX_TURN; i++) {
                System.out.println(Thread.currentThread().getName() + "@" + i);
            }
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        pool.execute(new MyRunnable());
        Future<String> submit = pool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                String s = "";
                for (int i = 0; i < MAX_TURN; i++) {
                    s += i;
                }
                return s;
            }
        });
        System.out.println(submit.get());
        pool.shutdown();
    }
}