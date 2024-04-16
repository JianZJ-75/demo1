package demo.printstream;

import java.io.PrintStream;

/**
 * @Author JianZJ
 * @Date 2024/4/16 17:00
 */
public class PrintStreamDemo4 {
    public static void main(String[] args) {
        /*
        * 打印流的应用场景
        * */

        // 获取打印流的对象, 此打印流在虚拟机启动的时候, 由虚拟机创建, 默认值向控制台
        // 特殊的打印流, 系臃肿的标准输出流, 是不能关闭的, 在系统中是唯一的
        // 如果关闭了, 就无法再次启动, 只能将虚拟机重启
        PrintStream out = System.out;

        // 调用打印流中的方法println
        // 写出数据, 自动换行, 自动刷新
        out.println("123");

//        out.close();

        out.println("你好你好");

        System.out.println("456");

    }
}
