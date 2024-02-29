package gui.com.jian.lesson06;

import javax.swing.*;
import java.awt.*;

/**
 * @Author JianZJ
 * @Date 2024/2/29 20:43
 */
public class TestTextDemo01 extends JFrame {

    public TestTextDemo01() {

        Container container = getContentPane();

        JTextField textField01 = new JTextField("hello");
        JTextField textField02 = new JTextField("world", 20);

        container.add(textField01, BorderLayout.NORTH);
        container.add(textField02, BorderLayout.SOUTH);

        setVisible(true);
        setBounds(100, 100, 500, 350);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TestTextDemo01();
    }
}
