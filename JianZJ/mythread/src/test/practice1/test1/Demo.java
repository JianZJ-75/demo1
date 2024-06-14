package test.practice1.test1;

/**
 * @Author JianZJ
 * @Date 2024/6/14 18:28
 */
public class Demo {
    public static void main(String[] args) {
        int n = 5;
        for (int i = 0; i < n; i++) {
            MYThread tmp = new MYThread();
            tmp.setName("Thread" + i);
            tmp.start();
        }
    }
}