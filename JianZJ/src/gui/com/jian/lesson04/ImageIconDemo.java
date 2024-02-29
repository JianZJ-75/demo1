package gui.com.jian.lesson04;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * @Author JianZJ
 * @Date 2024/2/29 19:31
 */
public class ImageIconDemo extends JFrame {
    public ImageIconDemo() {
        // 获取图片的地址
        JLabel label = new JLabel("ImageIcon");
        URL url = ImageIconDemo.class.getResource("tx.jpg");

        ImageIcon imageIcon = new ImageIcon(url);
        label.setIcon(imageIcon);
        label.setHorizontalAlignment(SwingConstants.CENTER);

        Container container = getContentPane();
        container.add(label);

        setBounds(100, 100, 500, 500);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new ImageIconDemo();
    }
}
