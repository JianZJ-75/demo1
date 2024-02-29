package gui.com.jian.lesson06;

import javax.swing.*;
import java.awt.*;

/**
 * @Author JianZJ
 * @Date 2024/2/29 20:46
 */
public class TestTextDemo02 extends JFrame {

    public TestTextDemo02() {

        Container container = getContentPane();

        // ****
        JPasswordField passwordField = new JPasswordField();
        passwordField.setEchoChar('*');

        container.add(passwordField);

        setVisible(true);
        setBounds(100, 100, 500, 350);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TestTextDemo02();
    }
}