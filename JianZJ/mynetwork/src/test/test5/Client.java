package test.test5;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author JianZJ
 * @Date 2024/6/21 20:42
 */
public class Client {
    public static void main(String[] args) throws IOException {
        // 创建Socket对象
        // 细节:
        // 在创建对象的同时会连接服务器端
        // 如果连接不上, 代码会报错
        Socket socket = new Socket("127.0.0.1", 1024);

        // 从连接通道中获取输出流
        OutputStream os = socket.getOutputStream();

        // 写出数据
        os.write("你好呀!".getBytes());

        // 释放资源
        os.close();
        socket.close();
    }
}