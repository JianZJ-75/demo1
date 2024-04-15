package test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/4/15 20:49
 */
public class Test08 {
    public static void main(String[] args) throws IOException {
        /*
        * 需求:
        *       将多个自定义对象序列化到文件中, 但是对象的个数不确定, 该如何操作呢?
        * */

        // 序列化多个对象
        List<Student> students = new ArrayList<Student>();
        Collections.addAll(students, new Student("hcc", 20, "滁州"), new Student("zyd", 20, "池州"));

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("myio\\src\\resource\\a.txt"));
        oos.writeObject(students);
        oos.close();

    }
}
