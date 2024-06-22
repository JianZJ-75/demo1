package test.test1;

/**
 * @Author JianZJ
 * @Date 2024/6/22 15:24
 */

public class Demo {
    public static void main(String[] args) throws ClassNotFoundException {
        // 第一种方式
        // 全类名: 包名 + 类名
        // 最为常用的
        Class cls1 = Class.forName("test.test1.Student");
        System.out.println(cls1);

        // 第二种方式
        // 一般更多的是当作参数进行传递
        Class cls2 = Student.class;
        System.out.println(cls1 == cls2);

        // 第三种方式
        // 当我们已经有了这个类的对象的时候, 才可以使用
        Student student = new Student();
        Class cls3 = student.getClass();
        System.out.println(cls1 == cls3);
    }
}
