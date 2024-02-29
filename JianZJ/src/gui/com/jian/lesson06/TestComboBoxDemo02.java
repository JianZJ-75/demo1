package gui.com.jian.lesson06;

import javax.swing.*;
import java.awt.*;

/**
 * @Author JianZJ
 * @Date 2024/2/29 20:37
 */
public class TestComboBoxDemo02 extends JFrame {

    public TestComboBoxDemo02() {

        Container container = getContentPane();

        // 生成列表的内容
        String[] contents = {"1", "2", "3"};

        JList jList = new JList(contents);

        container.add(jList);

        setVisible(true);
        setBounds(300, 300, 800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TestComboBoxDemo02();
    }
}
