package design;

/**
 * @Author JianZJ
 * @Date 2024/3/4 21:28
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class HuffmanNode {
    char data;
    int frequency;
    HuffmanNode left;
    HuffmanNode right;

    public HuffmanNode(char data, int frequency) {
        this.data = data;
        this.frequency = frequency;
    }
}

class HuffmanEncoder {
    private Map<Character, String> huffmanCodes;
    private HuffmanNode root;

    public HuffmanEncoder() {
        huffmanCodes = new HashMap<>();
    }

    public String compress(String text) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : text.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.frequency));
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            pq.offer(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        while (pq.size() > 1) {
            HuffmanNode left = pq.poll();
            HuffmanNode right = pq.poll();
            HuffmanNode parent = new HuffmanNode('\0', left.frequency + right.frequency);
            parent.left = left;
            parent.right = right;
            pq.offer(parent);
        }

        root = pq.poll();

        generateCodes(root, "");

        StringBuilder compressedText = new StringBuilder();
        for (char c : text.toCharArray()) {
            compressedText.append(huffmanCodes.get(c));
        }
        return compressedText.toString();
    }

    private void generateCodes(HuffmanNode node, String code) {
        if (node == null) {
            return;
        }
        if (node.data != '\0') {
            huffmanCodes.put(node.data, code);
        }
        generateCodes(node.left, code + "0");
        generateCodes(node.right, code + "1");
    }

    public HuffmanNode getRoot() {
        return root;
    }
}

public class HuffmanGUI extends JFrame {
    private JTextArea textArea;
    private JButton compressButton;
    private JButton uploadButton;
    private JButton downloadButton;
    private File selectedFile;

    public HuffmanGUI() {
        setTitle("Huffman Compression");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        uploadButton = new JButton("Upload File");
        uploadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    selectedFile = fileChooser.getSelectedFile();
                    try {
                        String fileContent = Files.readString(selectedFile.toPath());
                        textArea.setText(fileContent);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        buttonPanel.add(uploadButton);

        compressButton = new JButton("Compress");
        compressButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String content = textArea.getText();
                HuffmanEncoder encoder = new HuffmanEncoder();
                String compressedContent = encoder.compress(content);
                textArea.setText(compressedContent);
                visualizeHuffmanTree(encoder.getRoot());
            }
        });
        buttonPanel.add(compressButton);

        downloadButton = new JButton("Download Compressed File");
        downloadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (selectedFile != null) {
                    String compressedContent = textArea.getText();
                    try {
                        Path compressedFilePath = Paths.get(selectedFile.getParent(), "compressed_" + selectedFile.getName());
                        Files.write(compressedFilePath, compressedContent.getBytes());
                        JOptionPane.showMessageDialog(null, "Compressed file downloaded successfully.", "Download", JOptionPane.INFORMATION_MESSAGE);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        buttonPanel.add(downloadButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }

    private void visualizeHuffmanTree(HuffmanNode root) {
        JFrame frame = new JFrame("Huffman Tree Visualization");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawTree(g, getWidth() / 2, 30, root, 200);
            }
        };

        frame.add(panel);
        frame.setVisible(true);
    }

    private void drawTree(Graphics g, int x, int y, HuffmanNode node, int xOffset) {
        if (node == null) {
            return;
        }

        g.setColor(Color.BLACK);
        g.drawOval(x - 10, y - 10, 20, 20);
        g.drawString(String.valueOf(node.frequency), x - 5, y + 5);

        if (node.left != null) {
            g.setColor(Color.BLUE);
            g.drawLine(x, y, x - xOffset, y + 30);
            drawTree(g, x - xOffset, y + 30, node.left, xOffset / 2);
        }

        if (node.right != null) {
            g.setColor(Color.RED);
            g.drawLine(x, y, x + xOffset, y + 30);
            drawTree(g, x + xOffset, y + 30, node.right, xOffset / 2);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new HuffmanGUI();
            }
        });
    }
}
