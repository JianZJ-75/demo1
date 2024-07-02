package test.annotation;


import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Author JianZJ
 * @Date 2024/7/2 18:45
 */
public class Demo2 {
    @Test
    public void parseClass() throws ClassNotFoundException, NoSuchMethodException {
        // 先得到Class对象
        Class<?> cls = Class.forName("test.annotation.Demo");
        // 解析类上的注解
        // 判断注解上是否包含了某个注解
        if (cls.isAnnotationPresent(Test5.class)) {
            Test5 test5 = cls.getDeclaredAnnotation(Test5.class);
            System.out.println(test5.value());
            System.out.println(test5.aaa());
            System.out.println(Arrays.toString(test5.bbb()));
        }

        Method test1 = cls.getDeclaredMethod("test1");
        if (test1.isAnnotationPresent(Test5.class)) {
            Test5 test5 = test1.getDeclaredAnnotation(Test5.class);
            System.out.println(test5.value());
            System.out.println(test5.aaa());
            System.out.println(Arrays.toString(test5.bbb()));
        }
    }
}