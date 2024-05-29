package yzh;

/**
 * @Author JianZJ
 * @Date 2024/5/29 12:26
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardLayoutExample extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public CardLayoutExample() {
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Create cards
        JPanel card1 = new JPanel();
        card1.add(new JLabel("第一张卡片"));
        JPanel card2 = new JPanel();
        card2.add(new JLabel("第二张卡片"));
        JPanel card3 = new JPanel();
        card3.add(new JLabel("第三张卡片"));

        cardPanel.add(card1, "Card 1");
        cardPanel.add(card2, "Card 2");
        cardPanel.add(card3, "Card 3");

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.next(cardPanel);
            }
        });

        add(cardPanel, BorderLayout.CENTER);
        add(nextButton, BorderLayout.SOUTH);

        setTitle("CardLayout Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CardLayoutExample().setVisible(true);
            }
        });
    }
}
