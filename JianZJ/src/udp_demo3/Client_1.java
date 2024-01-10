package udp_demo3;

import java.io.IOException;
import java.net.*;
import java.util.Objects;
import java.util.Scanner;

/**
 * @Author: JianZJ
 * @Date: 2024/1/8 19:51
 */
public class Client_1  {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        // 创建发送对象
        DatagramSocket ds = new DatagramSocket(1025);
        // 确定发送对象
        InetAddress address = InetAddress.getByName("CY");
        int port = 1024;
        String s = new String();
        while (!Objects.equals(s, "886")) {
            // 打包数据
            s = sc.nextLine();
            byte[] bytes = s.getBytes();
            DatagramPacket dp = new DatagramPacket(bytes, bytes.length, address, port);
            // 发送对象
            ds.send(dp);
            if (Objects.equals(s, "886"))
                break;
            // 接收数据
            byte[] bytes1 = new byte[1024];
            dp = new DatagramPacket(bytes1, bytes1.length);
            ds.receive(dp);
            // 解析数据
            String data = new String(dp.getData(), 0, dp.getLength());
            System.out.println(dp.getAddress().getHostName() + ":" + data);
            if (Objects.equals(data, "886"))
                break;
        }
        // 释放资源
        ds.close();
        sc.close();
    }
}
