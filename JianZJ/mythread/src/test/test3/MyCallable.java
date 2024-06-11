package test.test3;

import java.util.concurrent.Callable;

/**
 * @Author JianZJ
 * @Date 2024/6/11 21:46
 */
public class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        return sum;
    }
}