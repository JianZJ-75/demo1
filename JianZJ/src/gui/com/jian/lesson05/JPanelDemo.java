package gui.com.jian.lesson05;

import javax.swing.*;
import java.awt.*;

/**
 * @Author JianZJ
 * @Date 2024/2/29 19:42
 */
public class JPanelDemo extends JFrame {

    public JPanelDemo() {
        Container container = getContentPane();

        // 后面两个参数的意思是间距
        container.setLayout(new GridLayout(2, 1, 10, 10));

        JPanel panel1 = new JPanel(new GridLayout(1, 3));
        JPanel panel2 = new JPanel(new GridLayout(1, 2));
        JPanel panel3 = new JPanel(new GridLayout(2, 1));
        JPanel panel4 = new JPanel(new GridLayout(3, 2));

        panel1.add(new JButton("1"));
        panel1.add(new JButton("1"));
        panel1.add(new JButton("1"));

        panel2.add(new JButton("2"));
        panel2.add(new JButton("2"));

        panel3.add(new JButton("3"));
        panel3.add(new JButton("3"));

        panel4.add(new JButton("4"));
        panel4.add(new JButton("4"));
        panel4.add(new JButton("4"));
        panel4.add(new JButton("4"));
        panel4.add(new JButton("4"));
        panel4.add(new JButton("4"));

        container.add(panel1);
        container.add(panel2);
        container.add(panel3);
        container.add(panel4);

        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JPanelDemo();
    }
}
