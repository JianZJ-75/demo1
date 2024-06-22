package test.test10;

import java.io.*;
import java.net.Socket;
import java.util.UUID;

/**
 * @Author JianZJ
 * @Date 2024/6/22 2:49
 */

public class MyRunnable implements Runnable {

    Socket socket;

    public MyRunnable(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        String name = UUID.randomUUID().toString().replace("-", "");
        File file = new File("mynetwork//src//resource//copy//" + name + ".txt");
        try {
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
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
