package gui.com.jian.lesson05;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * @Author JianZJ
 * @Date 2024/2/29 20:11
 */
public class JButtonDemo01 extends JFrame {

    public JButtonDemo01() {
        Container container = getContentPane();
        // 将一个图片变为图标
        URL url = JButtonDemo01.class.getResource("tx.jpg");
        Icon icon = new ImageIcon(url);

        // 把这个图标放在按钮上
        JButton button = new JButton();
        button.setIcon(icon);
        button.setToolTipText("图片按钮");

        container.add(button);

        setBounds(100, 100, 300, 300);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JButtonDemo01();
    }
}
