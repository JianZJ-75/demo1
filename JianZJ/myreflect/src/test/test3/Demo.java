package test.test3;

import java.lang.reflect.Field;

/**
 * @Author JianZJ
 * @Date 2024/6/22 16:41
 */

public class Demo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        // 获取字节码文件对象
        Class<?> cls = Class.forName("test.test3.Student");

        // 获取所有公共成员变量
        Field[] fields1 = cls.getFields();
        for (Field field : fields1) {
            System.out.println(field);
        }

        // 获取所有成员变量
        Field[] fields2 = cls.getDeclaredFields();
        for (Field field : fields2) {
            System.out.println(field);
        }

        // 获取单个成员变量
        Field gender = cls.getField("gender");
        System.out.println(gender);

        Field name = cls.getDeclaredField("name");
        System.out.println(name);

        // 获取权限修饰符
        int modifiers = name.getModifiers();
        System.out.println(modifiers);

        // 获取成员变量名
        String s = name.getName();
        System.out.println(s);

        // 获取数据类型
        Class<?> type = name.getType();
        System.out.println(type);

        // 获取成员变量记录的值
        Student student = new Student("zj", 20, "男");
        name.setAccessible(true);
        String value = (String) name.get(student);
        System.out.println(value);

        // 修改对象里面记录的值
        name.set(student, "hcc");
        System.out.println(student);
    }
}
