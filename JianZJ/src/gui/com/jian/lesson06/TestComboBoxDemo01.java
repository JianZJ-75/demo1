package gui.com.jian.lesson06;

import javax.swing.*;
import java.awt.*;

/**
 * @Author JianZJ
 * @Date 2024/2/29 20:31
 */
public class TestComboBoxDemo01 extends JFrame {

    public TestComboBoxDemo01() {

        Container container = getContentPane();

        JComboBox status = new JComboBox();

        status.addItem("...");
        status.addItem("正在热映");
        status.addItem("已下架");
        status.addItem("即将上映");

        container.add(status);

        setVisible(true);
        setBounds(100, 100, 800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TestComboBoxDemo01();
    }
}
