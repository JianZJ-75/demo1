package test.test6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

/**
 * @Author JianZJ
 * @Date 2024/6/21 21:12
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10000);
        Socket socket = ss.accept();
        String name = UUID.randomUUID().toString().replace("-", "");
        File file = new File("mynetwork//src//resource//copy//" + name + ".txt");
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
        byte[] buf = new byte[1024];
        int len;
        while ((len = bis.read(buf)) != -1) {
            bos.write(buf, 0, len);
        }
        bos.flush();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String str = "上传完毕...";
        bw.write(str);
        bw.flush();
        bos.close();
        socket.close();
        ss.close();
    }
}