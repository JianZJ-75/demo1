package yzh;

/**
 * @Author JianZJ
 * @Date 2024/5/29 12:27
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class SimpleTextEditor extends JFrame {
    private JTextArea textArea;

    public SimpleTextEditor() {
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("文件");
        menuBar.add(fileMenu);

        JMenuItem openItem = new JMenuItem("打开");
        fileMenu.add(openItem);
        openItem.addActionListener(e -> openFile());

        JMenuItem saveItem = new JMenuItem("保存");
        fileMenu.add(saveItem);
        saveItem.addActionListener(e -> saveFile());

        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem popupOpenItem = new JMenuItem("打开");
        popupMenu.add(popupOpenItem);
        popupOpenItem.addActionListener(e -> openFile());

        JMenuItem popupSaveItem = new JMenuItem("保存");
        popupMenu.add(popupSaveItem);
        popupSaveItem.addActionListener(e -> saveFile());

        textArea.setComponentPopupMenu(popupMenu);

        setTitle("Simple Text Editor");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void openFile() {
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                textArea.read(reader, null);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void saveFile() {
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showSaveDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                textArea.write(writer);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SimpleTextEditor().setVisible(true);
            }
        });
    }
}