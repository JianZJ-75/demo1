import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter(new File("src\\resource\\servlet\\tmp.txt"));
        fw.write("zj");
        fw.close();
    }
}