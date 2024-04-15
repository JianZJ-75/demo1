package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/4/15 20:58
 */
public class Test09 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // 1. 创建反序列化流对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("myio\\src\\resource\\a.txt"));

        // 2. 读取数据
        List<Student> students = (List<Student>) ois.readObject();
        for (Student student : students) {
            System.out.println(student);
        }

        // 3. 释放资源
        ois.close();

    }
}
