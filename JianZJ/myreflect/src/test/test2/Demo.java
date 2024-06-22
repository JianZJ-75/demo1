package test.test2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;

/**
 * @Author JianZJ
 * @Date 2024/6/22 15:36
 */

public class Demo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 获取字节码文件对象
        Class<?> cls = Class.forName("test.test2.Student");

        // 获取公共构造方法
        Constructor<?>[] cons1 = cls.getConstructors();
        for (Constructor<?> con : cons1) {
            System.out.println(con);
        }

        // 获取所有构造方法
        Constructor<?>[] cons2 = cls.getDeclaredConstructors();
        for (Constructor<?> con : cons2) {
            System.out.println(con);
        }

        // 获取单个构造方法
        Constructor<?> con1 = cls.getConstructor();
        System.out.println(con1);

        Constructor<?> con2 = cls.getConstructor(String.class);
        System.out.println(con2);

        Constructor<?> con3 = cls.getDeclaredConstructor();
        System.out.println(con3);

        Constructor<?> con4 = cls.getDeclaredConstructor(int.class);
        System.out.println(con4);

        Constructor<?> con5 = cls.getDeclaredConstructor(String.class, int.class);
        System.out.println(con5);

        // 获取权限修饰符 都是2次幂 运算效率高
        int modifiers = con5.getModifiers();
        System.out.println(modifiers);

        // 获取所有参数
        Parameter[] parameters = con5.getParameters();
        for (Parameter parameter : parameters) {
            System.out.println(parameter);
        }

        // 创建对象
        // 细节:
        // 私有方法不能直接通过这个方式创建对象
        // 暴力反射: 临时取消权限校验
        con5.setAccessible(true);
        Student stu = (Student) con5.newInstance("hcc", 12);

        System.out.println(stu);
    }
}
