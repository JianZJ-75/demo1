package test.design1;

/**
 * @Author JianZJ
 * @Date 2024/6/13 20:56
 */
public class Demo {
    public static void main(String[] args) {
        Consumer consumer = new Consumer();
        Producer producer = new Producer();

        consumer.start();
        producer.start();
    }
}