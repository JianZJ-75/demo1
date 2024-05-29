package yzh;

/**
 * @Author JianZJ
 * @Date 2024/5/29 12:28
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class SimpleCalculator extends JFrame {
    private JTextField display;
    private StringBuilder input;

    public SimpleCalculator() {
        input = new StringBuilder();
        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.PLAIN, 18));
        display.setHorizontalAlignment(JTextField.RIGHT);

        JPanel panel = new JPanel(new GridLayout(4, 4));
        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.PLAIN, 18));
            button.addActionListener(new ButtonClickListener());
            panel.add(button);
        }

        JButton clearButton = new JButton("MC");
        clearButton.setFont(new Font("Arial", Font.PLAIN, 18));
        clearButton.addActionListener(e -> {
            input.setLength(0);
            display.setText("");
        });

        setLayout(new BorderLayout());
        add(display, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        add(clearButton, BorderLayout.SOUTH);

        setTitle("Simple Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = ((JButton) e.getSource()).getText();
            if (command.equals("=")) {
                try {
                    String result = eval(input.toString());
                    display.setText(result);
                    input.setLength(0);
                    input.append(result);
                } catch (Exception ex) {
                    display.setText("Error");
                    input.setLength(0);
                }
            } else {
                input.append(command);
                display.setText(input.toString());
            }
        }
    }

    private String eval(String expression) throws ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
        return engine.eval(expression).toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SimpleCalculator().setVisible(true);
            }
        });
    }
}