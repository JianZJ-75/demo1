package test.junit;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author JianZJ
 * @Date 2024/7/2 19:16
 */
public class Test {
//    @MyJunit
    public void test1() {
        System.out.println("========test1==========");
    }

    @MyJunit
    public void test2() {
        System.out.println("========test2==========");
    }

//    @MyJunit
    public void test3() {
        System.out.println("========test3==========");
    }

    @MyJunit
    public void test4() {
        System.out.println("========test4==========");
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException {
        // 启动程序
        // 得到Class对象
        Class<?> cls = Class.forName("test.junit.Test");
        // 获取这个类中的所有成员方法
        Method[] methods = cls.getDeclaredMethods();
        // 遍历查看是否存在注解
        for (Method method : methods) {
            if (method.isAnnotationPresent(MyJunit.class)) {
                Object o = cls.newInstance();
                method.invoke(o);
            }
        }
    }
}