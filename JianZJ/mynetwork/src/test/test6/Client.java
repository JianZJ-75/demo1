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
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        byte[] buf = new byte[1024];
        int len;
        while ((len = bis.read(buf)) != -1) {
            bos.write(buf, 0, len);
        }
        socket.shutdownOutput();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
        bos.close();
        bis.close();
        socket.close();
    }
}