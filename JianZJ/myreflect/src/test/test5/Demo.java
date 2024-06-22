package test.test5;

import java.io.*;
import java.lang.reflect.Field;

/**
 * @Author JianZJ
 * @Date 2024/6/22 17:12
 */

public class Demo {
    public static void main(String[] args) throws IOException, IllegalAccessException {
        Student student = new Student("hcc", 20, "女", 110, "daoguan");
        Teacher teacher = new Teacher("Hcc", 0);

        saveObject(student);
        saveObject(teacher);

    }

    // 把对象里面所有的成员变量名和值保存到本地文件中
    private static void saveObject(Object obj) throws IllegalAccessException, IOException {
        // 获取字节码文件对象
        Class<?> cls = obj.getClass();

        // 创建IO流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("myreflect\\src\\resource\\test\\a.txt", true)));

        // 获取成员变量
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String name = field.getName();
            Object value = field.get(obj);
            bw.write(name + "=" + value);
            bw.newLine();
        }
        bw.close();
    }
}
