package test.test6;

import java.io.*;
import java.net.Socket;

/**
 * @Author JianZJ
 * @Date 2024/6/21 21:12
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 1024);
        OutputStream os = socket.getOutputStream();
        File file = new File("mynetwork\\resources\\test\\namelist.txt");
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        byte[] buf = new byte[1024];
        int len;
        while ((len = bis.read(buf)) != -1) {
            os.write(buf, 0, len);
        }
        bis.close();
        os.close();
    }
}