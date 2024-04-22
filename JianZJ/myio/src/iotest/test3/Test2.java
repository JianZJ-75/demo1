package iotest.test3;

import cn.hutool.core.util.ReUtil;

import java.io.*;
import java.util.List;
import java.util.Scanner;

/**
 * @Author JianZJ
 * @Date 2024/4/22 20:07
 */
public class Test2 {
    public static void main(String[] args) throws IOException {
        /*
         * 登陆注册2(学生独立完成)
         *
         * 需求: 写一个登陆小案例(添加锁定账号功能)
         *
         * 步骤:
         *      将正确的用户名和密码手动保存在本地的userinfo.txt中
         *      保存格式为: username=zhangsan&password=123&count=0
         *      让用户键盘录入用户名和密码
         *      比较用户录入的和正确的用户名密码是否一致
         *      如果一致则打印登陆成功
         *      如果不一致则打印登陆失败, 连续输错三次被锁定
         * */

        BufferedReader br = new BufferedReader(new FileReader("myio\\src\\resource\\userinfo.txt"));
        String line = br.readLine();
        br.close();

        List<String> all = ReUtil.findAll("=([0-9|A-Z|a-z]+)(&|)", line, 1);
        String rightUsername = all.get(0);
        String rightPassword = all.get(1);
        int count = Integer.parseInt(all.get(2));

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String username = sc.nextLine();
        System.out.println("请输入密码");
        String password = sc.nextLine();

        if (rightUsername.equals(username) && rightPassword.equals(password) && count < 3) {
            count = 0;
            System.out.println("登陆成功!");
        } else if (++count < 3) {
            System.out.println("登陆失败! 再输错" + (3 - count) + "次账号将会被锁定!");
        } else {
            System.out.println("该账号已被锁定!!!");
        }

        StringBuilder sb = new StringBuilder();
        sb.append("username=" + rightUsername);
        sb.append("&password=" + rightPassword);
        sb.append("&count=" + count);

        BufferedWriter bw = new BufferedWriter(new FileWriter("myio\\src\\resource\\userinfo.txt"));
        bw.write(sb.toString());
        bw.close();

    }
}
