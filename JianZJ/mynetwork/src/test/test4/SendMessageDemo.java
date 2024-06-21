package test.test4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * @Author JianZJ
 * @Date 2024/6/20 21:40
 */
public class SendMessageDemo {
    public static void main(String[] args) throws IOException {
        // 创建MulticastSocket对象
        MulticastSocket ms = new MulticastSocket();

        // 创建DatagramPacket对象
        String str = "hello multicastsocket!";
        byte[] buf = str.getBytes();
        InetAddress address = InetAddress.getByName("224.0.0.1");
        int port = 10000;
        DatagramPacket dp = new DatagramPacket(buf, buf.length, address, port);

        // 调用MulticastSocket对象发送数据方法发送数据
        ms.send(dp);

        // 释放资源
        ms.close();
    }
}