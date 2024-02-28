package test;

import javax.swing.*;
import java.awt.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;

/**
 * @Author: JianZJ
 * @Date: 2024/1/2 23:04
 */
public class Test2 {
    public void init() {
        JFrame jf = new JFrame("JianZJ");
        jf.setVisible(true);
        jf.setLayout(new FlowLayout());
        Button btn = new Button("hello");
        btn.setBackground(Color.red);
        jf.add(btn);
        JLabel label = new JLabel("no!!!");
        label.setOpaque(true);
        label.setBackground(Color.orange);
        jf.add(label);
        jf.getContentPane().setBackground(Color.CYAN);
        jf.pack();
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new Test2().init();
    }
}
