package yzh;

/**
 * @Author JianZJ
 * @Date 2024/5/29 12:27
 */
import javax.swing.*;
import java.awt.*;

public class FontExample extends JFrame {
    private JComboBox<String> fontComboBox;
    private JLabel textLabel;

    public FontExample() {
        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        fontComboBox = new JComboBox<>(fonts);
        fontComboBox.addActionListener(e -> updateFont());

        textLabel = new JLabel("Java入门与精通");
        textLabel.setFont(new Font("Serif", Font.PLAIN, 24));

        setLayout(new BorderLayout());
        add(fontComboBox, BorderLayout.NORTH);
        add(textLabel, BorderLayout.CENTER);

        setTitle("Font Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void updateFont() {
        String selectedFont = (String) fontComboBox.getSelectedItem();
        textLabel.setFont(new Font(selectedFont, Font.PLAIN, 24));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FontExample().setVisible(true);
            }
        });
    }
}