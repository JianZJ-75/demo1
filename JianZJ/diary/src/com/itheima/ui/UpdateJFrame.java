package com.itheima.ui;

import com.itheima.domain.Note;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UpdateJFrame extends JFrame implements ActionListener {
    //定义标题输入框
    JTextField titleText  = new JTextField();

    //定义内容的输入区域
    JTextArea contentText = new JTextArea();

    //定义修改按钮
    JButton update = new JButton("修改");

    //定义取消按钮
    JButton cancel = new JButton("取消");

    // 表格数据
    List<Note> noteList = new ArrayList<>();

    // 所修改的数据索引
    int index;

    public UpdateJFrame(int index){
        this.index = index;

        //初始化界面
        initFrame();

        //初始化组件
        initView();

        // 初始化显示信息
        initText();

        //让界面展示出来
        this.setVisible(true);
    }

    private void initText() {
        // 获取数据
        getData();
        // 修改文本框
        Note now = noteList.get(index);
        titleText.setText(now.getTitle());
        contentText.setText(now.getContent());
    }

    // 将数据反序列化获取
    private void getData() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("diary\\temp.txt"));
            noteList = (List<Note>) ois.readObject();
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == update){
            System.out.println("修改按钮被点击了");
            // 修改数据
            changeNote();
            // 写入temp
            writeNote();
            new NoteJFrame();
            this.dispose();
        }else if(obj == cancel){
            System.out.println("取消按钮被点击了");
            new NoteJFrame();
            this.dispose();
        }
    }

    // 序列化对象
    private void writeNote() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("diary\\temp.txt"));
            oos.writeObject(noteList);
            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 修改数据
    private void changeNote() {
        Note now = noteList.get(index);
        now.setTitle(titleText.getText());
        now.setContent(contentText.getText());
    }

    private void initView() {
        //定义最上面的每日一记
        JLabel title = new JLabel("每日一记");
        title.setBounds(220, 20, 584, 50);
        title.setFont(new Font("宋体", Font.BOLD, 32));
        this.getContentPane().add(title);

        //定义文字：标题
        JLabel subject = new JLabel("标题");
        subject.setBounds(70,90,100,30);
        subject.setFont(new Font("宋体",Font.PLAIN,16));
        this.getContentPane().add(subject);

        //定义文字：内容
        JLabel content = new JLabel("内容");
        content.setBounds(70,140,100,30);
        content.setFont(new Font("宋体",Font.PLAIN,16));
        this.getContentPane().add(content);


        //设置标题的输入框
        titleText.setBounds(120,90,426,30);
        titleText.setFont(new Font("宋体",Font.PLAIN,16));
        this.getContentPane().add(titleText);

        //设置内容的输入框
        contentText.setBounds(120,140,426,300);
        contentText.setFont(new Font("宋体",Font.PLAIN,16));
        this.getContentPane().add(contentText);

        //设置保存按钮
        update.setBounds(132,466,140,40);
        update.setFont(new Font("宋体",Font.PLAIN,24));
        update.addActionListener(this);
        this.getContentPane().add(update);

        //设置取消按钮
        cancel.setBounds(312,466,140,40);
        cancel.setFont(new Font("宋体",Font.PLAIN,24));
        cancel.addActionListener(this);
        this.getContentPane().add(cancel);

    }


    //对添加界面的一些设置
    private void initFrame() {
        //设置界面的宽高
        this.setSize(600, 600);
        //设置界面的标题
        this.setTitle("每日一记（添加日记）");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //取消默认的居中放置，只有取消了才会按照XY轴的形式添加组件
        this.setLayout(null);
        //设置背景颜色
        this.getContentPane().setBackground(new Color(212,212,212));
    }
}