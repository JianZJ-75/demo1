package test.test6;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @Author JianZJ
 * @Date 2024/6/22 17:23
 */

public class Demo {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 读取配置文件中的信息
        Properties prop = new Properties();
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("myreflect\\src\\resource\\prop\\tmp.properties"));
        prop.load(bis);
        bis.close();
        System.out.println(prop);

        // 获取全类名和方法名
        String className = (String) prop.get("classname");
        String methodName = (String) prop.get("method");
        System.out.println(className);
        System.out.println(methodName);

        // 利用反射创建对象并运行方法
        Class<?> cls = Class.forName(className);
        Constructor<?> con = cls.getDeclaredConstructor();
        Object o = con.newInstance();
        System.out.println(o);

        // 获取成员方法并运行
        Method method = cls.getDeclaredMethod(methodName);
        method.setAccessible(true);
        method.invoke(o);
    }
}
