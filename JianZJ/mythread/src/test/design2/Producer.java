package test.design2;

import java.util.concurrent.BlockingQueue;

/**
 * @Author JianZJ
 * @Date 2024/6/13 20:56
 */
public class Producer extends Thread{
    BlockingQueue<String> queue;

    public Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                queue.put("phone");
                System.out.println("produce completely");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}