package design;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/3/1 0:48
 */
public class Castle {
    // 行
    private int rows;
    // 列
    private int lines;
    // 存总房间数
    private int quantity;
    // 存最大房间大小
    private int max_size = 1;
    // 每个房间大小
    private int[] size;
    // 主窗口宽
    private int width = 750;
    // 主窗口高
    private int height = 750;
    // 房间边长
    private int base_size = 50;
    // 房间间距
    private int base_interval = 10;
    // 房间面板宽
    private int panel_width;
    // 房间面板高
    private int panel_height;
    // 房间列表
    private List<MyJPanel> panelList;
    // 行按钮列表
    private List<MyJButton> rows_buttons;
    // 列按钮列表
    private List<MyJButton> lines_buttons;

    // 获取行的值
    public void getRows() {
        int cnt = 0;
        while (!(this.rows >= 1 && this.rows <= 50)) {
            if (cnt > 0) {
                JOptionPane.showMessageDialog(null, "Enter invalid, please re-enter!");
            }
            cnt++;
            this.rows = Integer.parseInt(JOptionPane.showInputDialog("Enter number of rows: (1 ~ 50)"));
        }
    }

    // 获取列的值
    public void getLines() {
        int cnt = 0;
        while (!(this.lines >= 1 && this.lines <= 50)) {
            if (cnt > 0) {
                JOptionPane.showMessageDialog(null, "Enter invalid, please re-enter!");
            }
            cnt++;
            this.lines = Integer.parseInt(JOptionPane.showInputDialog("Enter number of lines: (1 ~ 50)"));
        }
    }

    public void load() {
        // 获取行与列的值
        getRows();
        getLines();
        init();
        new MyJFrame("Castle problem");
    }

    // 初始化
    public void init() {
        // 初始房间数量
        quantity = rows * lines;
        size = new int[quantity + 1];
        Arrays.setAll(size, i -> 1);
        panelList = new ArrayList<>();
        rows_buttons = new ArrayList<>();
        lines_buttons = new ArrayList<>();
    }

    // 主窗口
    class MyJFrame extends JFrame {

        public MyJFrame(String title) {
            super(title);
            calc();

            Container container = getContentPane();
            container.setLayout(null);

            // 面板
            JPanel panel1 = new JPanel();
            JPanel panel2 = new JPanel();
            JPanel panel3 = new JPanel();

            // 按钮
            JButton button = new JButton("compute");
            // 监听鼠标
            button.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    // 处理
                    changeColor();
                    // 弹窗
                    JOptionPane.showMessageDialog(null, "Number of rooms: " + quantity + "\nLargest room size: " + max_size);
                }
            });

            // 面板设置
            // 面板1
            panel1.setBackground(Color.BLACK);
            panel1.setBounds(0, 0, panel_width, panel_height);
            panel1.setLayout(null);

            // 面板2
            panel2.setBackground(Color.BLACK);
            panel2.setBounds(base_interval, base_interval, panel_width - 2 * base_interval, panel_height - 2 * base_interval);
            panel2.setLayout(null);

            // 添加房间面板
            addRoom(panel2);

            // 添加边
            addWall(panel2);

            // 面板3
            panel3.add(button);
            panel3.setBounds(0, panel_height, panel_width, 40);

            panel1.add(panel2);

            container.add(panel1);
            container.add(panel3);

            setBounds(0, 0, width, height);
            setVisible(true);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setResizable(false);
        }

        // 添加墙
        public void addWall(JPanel panel2) {
            int x = 0, y = base_size;
            // 行边
            int idx = 0;
            for (int i = 1; i <= rows - 1; i++) {
                for (int j = 1; j <= lines; j++) {
                    ++idx;
                    MyJButton button = new MyJButton(panelList.get(idx - 1), panelList.get(idx + lines - 1));
                    button.addActionListener(button.new MyActionListener(button));
                    button.setBounds(x, y, base_size, base_interval);
                    button.setBackground(Color.BLACK);
                    panel2.add(button);
                    rows_buttons.add(button);
                    x += base_size + base_interval;
                }
                x = 0;
                y += base_size + base_interval;
            }

            x = base_size;
            y = 0;
            // 列边
            idx = 0;
            for (int i = 1; i <= rows; i++) {
                for (int j = 1; j <= lines - 1; j++) {
                    ++idx;
                    MyJButton button = new MyJButton(panelList.get(idx - 1), panelList.get(idx));
                    button.addActionListener(button.new MyActionListener(button));
                    button.setBounds(x, y, base_interval, base_size);
                    button.setBackground(Color.BLACK);
                    panel2.add(button);
                    lines_buttons.add(button);
                    x += base_size + base_interval;
                }
                ++idx;
                x = base_size;
                y += base_size + base_interval;
            }
        }

        // 改色
        public void changeColor() {
            for (var i : panelList) {
                int x = new DSU().find(i.id);
                if (size[x] == max_size)
                    i.setBackground(Color.ORANGE);
                else
                    i.setBackground(Color.YELLOW);
            }
        }

        // 添加房间
        public void addRoom(JPanel panel2) {
            int x = 0, y = 0, idx = 0;
            for (int i = 1; i <= rows; i++) {
                for (int j = 1; j <= lines; j++) {
                    MyJPanel panel = new MyJPanel(++idx, idx);
                    panel.setBounds(x, y, base_size, base_size);
                    panel2.add(panel);
                    panelList.add(panel);
                    x += base_size + base_interval;
                }
                x = 0;
                y += base_size + base_interval;
            }
        }

        // 计算主窗口大小
        public void calc() {
            if (!(base_size * rows + (rows + 1) * base_interval <= height && base_size * lines + (lines + 1) * base_interval <= width)) {
                // 计算能容下的最大大小
                base_interval = Math.min(height / (rows * 5 + rows + 1), width / (lines * 5 + lines + 1));
                base_size = (height - base_interval) / rows - base_interval;
            }
            height = base_size * rows + (rows + 1) * base_interval;
            width = base_size * lines + (lines + 1) * base_interval;
            // 计算主面板大小
            panel_height = height;
            panel_width = width;
            // 上30遮挡，下40按钮
            height += 70;
            // 左右遮挡7
            width += 14;
        }
    }

    // 边类
    class MyJButton extends JButton {
        public MyJPanel myJPanel1;
        public MyJPanel myJPanel2;

        public MyJButton(MyJPanel myJPanel1, MyJPanel myJPanel2) {
            this.myJPanel1 = myJPanel1;
            this.myJPanel2 = myJPanel2;
        }

        // 按钮监听类
        class MyActionListener implements ActionListener {
            MyJButton button;

            public MyActionListener(MyJButton button) {
                this.button = button;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                if (myJPanel1.idx != myJPanel2.idx) {
                    quantity--;
                    // 合并
                    new DSU(myJPanel1, myJPanel2);
                }
                // 换色
                button.setBackground(Color.WHITE);
            }
        }
    }

    // 房间类
    class MyJPanel extends JPanel {
        // 面板所对应的房间
        public int idx;
        // 面板id
        public int id;

        public MyJPanel(int idx, int id) {
            this.id = id;
            this.idx = idx;
            setBackground(Color.WHITE);
            setSize(base_size, base_size);
        }
    }

    // 并查集类
    class DSU {

        public DSU() {}

        public DSU(MyJPanel panel1, MyJPanel panel2) {
            union(panel1.id, panel2.id);
        }

        public int find(int x) {
            MyJPanel panel = panelList.get(x - 1);
            if (panel.idx == panel.id)
                return panel.id;
            panel.idx = find(panel.idx);
            return panel.idx;
        }

        public void union(int x, int y) {
            int fx = find(x), fy = find(y);
            if (fx == fy)
                return;
            if (size[fx] > size[fy]) {
                int t = fy;
                fy = fx;
                fx = t;
            }
            MyJPanel panel = panelList.get(fx - 1);
            panel.idx = fy;
            size[fy] += size[fx];
            max_size = Math.max(max_size, size[fy]);
        }
    }

    public static void main(String[] args) {
        // 启动
        new Castle().load();
    }
}