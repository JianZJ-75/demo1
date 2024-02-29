package test;

import gui.com.jian.lesson05.JScrollDemo;

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
        JFrame jFrame = new JFrame("zj") {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                g.setColor(Color.BLACK);
//                g.fillRect(13, 30, 50, 50);
                g.fillRect(323, 790, 50, 50);
                g.fillRect(323 + 60, 790, 50, 50);

                int x = 7, y = 30 + 3;
                for (int i = 1; i <= 50; i++) {
                    g.fillRect(x, y, 10, 10);
                    y += 15;
                }
                System.out.println(y);
                g.fillRect(x + 213, y, 30, 30);

            }
        };
        jFrame.setBounds(0, 0, 1536, 850);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        jFrame.setResizable(false);
    }
    public static void main(String[] args) {
        new Test2().init();
    }
}
