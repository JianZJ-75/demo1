package demo.objectstream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @Author JianZJ
 * @Date 2024/4/15 19:49
 */
public class ObjectStreamDemo1 {
    public static void main(String[] args) throws IOException {
        /*
        * 需求:
        *       利用序列化流/对象操作输出流, 把一个对象写到本地文件中
        *
        * 构造方法:
        *       public ObjectOutputStream(OutputStream out)         把基本流包装成高级流
        *
        * 成员方法:
        *       public final void writeObject(Object obj)                 把对象序列化(写出)到文件中去
        * */

        // 1. 创建对象
        Student stu = new Student("hcc", 20, "hfuu");

        // 2. 创建序列化对象/对象操作输出流
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("myio\\src\\resource\\a.txt"));

        // 3. 写出数据
        oos.writeObject(stu);

        // 4. 释放资源
        oos.close();

    }
}
