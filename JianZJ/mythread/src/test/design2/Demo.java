package test.design2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Author JianZJ
 * @Date 2024/6/13 20:56
 */
public class Demo {
    public static void main(String[] args) {

        BlockingQueue<String> queue = new ArrayBlockingQueue<>(1);

        Consumer consumer = new Consumer(queue);
        Producer producer = new Producer(queue);

        consumer.start();
        producer.start();
    }
}