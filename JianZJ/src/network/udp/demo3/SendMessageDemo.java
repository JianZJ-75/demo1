package network.udp.demo3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * @Author JianZJ
 * @Date 2024/3/21 23:33
 */
public class SendMessageDemo {
    public static void main(String[] args) throws IOException {
        // 创建MulticastSocket对象
        MulticastSocket ms = new MulticastSocket();

        // 创建DatagramPacket对象
        String s = "hello!";
        byte[] bytes = s.getBytes();
        InetAddress address = InetAddress.getByName("224.0.0.1");
        int port = 1024;

        DatagramPacket dp = new DatagramPacket(bytes, bytes.length, address, port);

        // 调用MulticastSocket发送数据方法发送数据
        ms.send(dp);

        // 释放资源
        ms.close();
    }
}
