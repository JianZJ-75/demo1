package test.design2;

import java.util.concurrent.BlockingQueue;

/**
 * @Author JianZJ
 * @Date 2024/6/13 20:56
 */
public class Consumer extends Thread{
    BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String product = queue.take();
                System.out.println(product);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}