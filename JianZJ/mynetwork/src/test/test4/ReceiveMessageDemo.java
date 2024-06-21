package test.test4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * @Author JianZJ
 * @Date 2024/6/20 21:40
 */
public class ReceiveMessageDemo {
    public static void main(String[] args) throws IOException {
        // 创建MulticastSocket对象
        MulticastSocket ms = new MulticastSocket(10000);

        // 将当前本机, 添加到224.0.0.1这一组当中
        InetAddress address = InetAddress.getByName("224.0.0.1");
        ms.joinGroup(address);

        // 创建DatagramPacket对象
        byte[] buf = new byte[1024];
        DatagramPacket dp = new DatagramPacket(buf, buf.length);

        // 接收数据
        ms.receive(dp);

        // 解析数据
        byte[] data = dp.getData();
        int len = dp.getLength();
        InetAddress ip = dp.getAddress();
        int port = dp.getPort();
        System.out.println(ip + "@" + port + " : " + new String(data, 0, len));

        // 释放资源
        ms.close();
    }
}