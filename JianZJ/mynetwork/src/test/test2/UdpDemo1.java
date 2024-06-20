package test.test2;

import java.io.IOException;
import java.net.*;

/**
 * @Author JianZJ
 * @Date 2024/6/20 21:10
 */
public class UdpDemo1 {
    public static void main(String[] args) throws IOException {
        // 创建DatagramSocket对象
        // 细节:
        // 绑定端口: 以后我们就是通过这个端口往外发送
        // 空参: 所有可用的端口中随机一个进行使用
        // 有参: 指定端口号进行绑定
        DatagramSocket ds = new DatagramSocket();

        // 打包数据
        String str = "hello udp!";
        byte[] buf = str.getBytes();
        InetAddress address = InetAddress.getByName("127.0.0.1");
        int port = 1024;
        DatagramPacket dp = new DatagramPacket(buf, buf.length, address, port);

        // 发送数据
        ds.send(dp);

        // 释放资源
        ds.close();
    }
}