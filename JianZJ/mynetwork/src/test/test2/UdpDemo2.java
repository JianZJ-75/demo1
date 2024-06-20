package test.test2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @Author JianZJ
 * @Date 2024/6/20 21:15
 */
public class UdpDemo2 {
    public static void main(String[] args) throws IOException {
        // 创建DatagramSocket对象
        // 细节:
        // 在接收的时候, 一定要绑定端口
        // 而且绑定的端口一定要和发送的端口保持一致
        DatagramSocket ds = new DatagramSocket(1024);

        // 接收数据包
        byte[] buf = new byte[1024];
        DatagramPacket dp = new DatagramPacket(buf, buf.length);

        // 细节:
        // 该方法是阻塞的
        // 程序需执行到这一步的时候, 会在这里死等
        // 等待发送端发送消息
        ds.receive(dp);

        // 解析数据包
        byte[] data = dp.getData();
        int len = dp.getLength();
        InetAddress address = dp.getAddress();
        int port = dp.getPort();
        System.out.println(address + "@" + port + " : " + new String(data, 0, len));

        // 释放资源
        ds.close();
    }
}