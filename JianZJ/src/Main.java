import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: JianZJ
 * @Date: 2024/1/9 15:37
 */

public class Main {

    static final int K = 828;

    public static void main(String[] args) throws IOException {

        File fb = new File("src\\IO\\resource\\fb.jpg");

        File origin = new File("src\\IO\\resource\\zj.jpg");

        FileInputStream fis = new FileInputStream(origin);
        FileOutputStream fos = new FileOutputStream(fb);

        int b;
        while ((b = fis.read()) != -1) {
            fos.write(b);
        }

        FileInputStream fis1 = new FileInputStream(fb);
        FileOutputStream fos1 = new FileOutputStream(origin);

        while ((b = fis1.read()) != -1) {
            fos1.write(b ^ K);
        }

        fis1.close();
        fos1.close();
        fos.close();
        fis.close();

        fb.delete();

    }
}