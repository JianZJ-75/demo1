package gui.com.jian.lesson05;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * @Author JianZJ
 * @Date 2024/2/29 20:20
 */
public class JButtonDemo02 extends JFrame{

    public JButtonDemo02() {
        Container container = getContentPane();
        // 将一个图片变为图标
        URL url = JButtonDemo01.class.getResource("tx.jpg");
        Icon icon = new ImageIcon(url);

        // 单选框
        JRadioButton radioButton01 = new JRadioButton("JRadioButton01");
        JRadioButton radioButton02 = new JRadioButton("JRadioButton02");
        JRadioButton radioButton03 = new JRadioButton("JRadioButton03");

        // 由于单选框只能选择一个，分组，一个组中只能选择一个
        ButtonGroup group = new ButtonGroup();
        group.add(radioButton01);
        group.add(radioButton02);
        group.add(radioButton03);

        container.add(radioButton01, BorderLayout.NORTH);
        container.add(radioButton02, BorderLayout.CENTER);
        container.add(radioButton03, BorderLayout.SOUTH);

        setBounds(100, 100, 300, 300);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JButtonDemo02();
    }
}