package udp_demo2;

import java.io.IOException;
import java.net.*;
import java.util.Objects;
import java.util.Scanner;

/**
 * @Author: JianZJ
 * @Date: 2024/1/8 0:10
 */
public class SendMessage {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        // 创建对象
        DatagramSocket ds = new DatagramSocket();
        // 打包数据
        InetAddress address = InetAddress.getByName("127.0.0.1");
        int port = 1024;
        while (true) {
            System.out.println("请输入要发送的信息:");
            String s = sc.nextLine();
            if (Objects.equals("886", s))
                break;
            byte[] bytes = s.getBytes();
            DatagramPacket dp = new DatagramPacket(bytes, bytes.length, address, port);
            // 发送数据
            ds.send(dp);
        }
        // 释放资源
        ds.close();
        sc.close();
    }
}
