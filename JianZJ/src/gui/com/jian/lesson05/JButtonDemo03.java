package gui.com.jian.lesson05;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * @Author JianZJ
 * @Date 2024/2/29 20:25
 */
public class JButtonDemo03 extends JFrame {

    public JButtonDemo03() {
        Container container = getContentPane();
        // 将一个图片变为图标
        URL url = JButtonDemo01.class.getResource("tx.jpg");
        Icon icon = new ImageIcon(url);

        // 多选框
        JCheckBox checkBox01 = new JCheckBox("checkBox01");
        JCheckBox checkBox02 = new JCheckBox("checkBox02");

        container.add(checkBox01, BorderLayout.NORTH);
        container.add(checkBox02, BorderLayout.SOUTH);

        setBounds(100, 100, 300, 300);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JButtonDemo03();
    }
}

