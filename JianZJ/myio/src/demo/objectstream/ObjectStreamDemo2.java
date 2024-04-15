package demo.objectstream;

import java.io.*;

/**
 * @Author JianZJ
 * @Date 2024/4/15 19:49
 */
public class ObjectStreamDemo2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*
        * 需求:
        *       利用反序列化流/对象操作输入流, 把文件中的对象读取到程序当中
        *
        * 构造方法:
        *       public ObjectInputStream(InputStream out)           把基本流包装成高级流
        *
        * 成员方法:
        *       public Object readObject()                          把序列化到本地文件中的对象, 读取到程序中来
        * */

        // 1. 创建反序列化流对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("myio\\src\\resource\\a.txt"));

        // 2. 读取数据
        Student stu = (Student) ois.readObject();

        // 3. 打印对象
        System.out.println(stu);

        // 4. 释放资源
        ois.close();

    }
}
