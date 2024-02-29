package gui.com.jian.lesson05;

import com.sun.source.tree.YieldTree;

import javax.swing.*;
import java.awt.*;

/**
 * @Author JianZJ
 * @Date 2024/2/29 19:55
 */
public class JScrollDemo extends JFrame {

    public JScrollDemo() {
        Container container = getContentPane();

        // 文本域
        JTextArea textArea = new JTextArea(20, 50);
        textArea.setText("op!!!");

        // Scroll面板
        JScrollPane scrollPane = new JScrollPane(textArea);
        container.add(scrollPane);

        setVisible(true);
        setBounds(100, 100, 350, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JScrollDemo();
    }
}
