package test.test4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @Author JianZJ
 * @Date 2024/6/22 16:54
 */

public class Demo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // 获取字节码文件对象
        Class<?> cls = Class.forName("test.test4.Student");

        // 获取里面所有公共成员方法(会包含父类的所有成员方法)
        Method[] methods1 = cls.getMethods();
        for (Method method : methods1) {
            System.out.println(method);
        }

        // 获取里面所有成员方法(不能获取父类的)
        Method[] methods2 = cls.getDeclaredMethods();
        for (Method method : methods2) {
            System.out.println(method);
        }

        // 获取单个成员方法
        Method m1 = cls.getMethod("sleep");
        System.out.println(m1);

        Method m2 = cls.getDeclaredMethod("eat", String.class);
        System.out.println(m2);

        // 获取方法的修饰符
        int modifiers = m2.getModifiers();
        System.out.println(modifiers);

        // 获取方法的名字
        String s = m2.getName();
        System.out.println(s);

        // 获取方法的形参
        Parameter[] parameters = m2.getParameters();
        for (Parameter parameter : parameters) {
            System.out.println(parameter);
        }

        // 获取方法抛出的异常
        Class<?>[] exceptionTypes = m2.getExceptionTypes();
        for (Class<?> exceptionType : exceptionTypes) {
            System.out.println(exceptionType);
        }

        // 运行方法
        /*
        * Object invoke(Object obj, Object... args): 运行方法
        * 参数一: 用obj对象调用该方法
        * 参数二: 调用该方法传递的参数(如果没有就不写)
        * 返回值: 方法的返回值(如果没有就不写)
        * */
        Student student = new Student();
        m2.setAccessible(true);
        String res = (String) m2.invoke(student, "奥利给");
        System.out.println(res);
    }
}
