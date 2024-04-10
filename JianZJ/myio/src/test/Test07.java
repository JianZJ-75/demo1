package test;

import java.io.*;

/**
 * @Author JianZJ
 * @Date 2024/4/10 20:47
 */
public class Test07 {
    public static void main(String[] args) throws IOException {
        /*
        * 实现一个验证程序运行次数的小程序, 要求如下:
        * 1. 当程序运行超过3次时给出提示: 本软件只能免费使用3次, 欢迎您注册会员后继续使用~
        * 2. 程序运行演示如下:
        *       第一次运行控制台输出: 欢迎使用本软件, 第1次使用免费
        *       第二次运行控制台输出: 欢迎使用本软件, 第2次使用免费
        *       第三次运行控制台输出: 欢迎使用本软件, 第3次使用免费
        *       第四次及之后运行控制台输出: 本软件只能免费使用3次, 欢迎您注册会员后继续使用~
        * */

        // 1. 把文件中的数字读取到内存中
        // 原则:
        // IO: 随用随创建
        //     什么时候不用什么时候关闭
        File file = new File("myio\\src\\resource\\count.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = br.readLine();
        br.close();
        int count = Integer.parseInt(line);
        count++;

        // 2. 判断
        if (count <= 3) {
            System.out.println("欢迎使用本软件, 第" + count + "次使用免费");
        } else {
            System.out.println("本软件只能免费使用3次, 欢迎您注册会员后继续使用~");
        }

        // 3. 把当前自增之后的count写出到文件中
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write(count + "");
        bw.close();

    }
}
