
package calculator.gui;

import calculator.core.BinaryCalculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorGUI extends JFrame {
    private JTextField input1;
    private JTextField input2;
    private JTextField result;
    private JButton addButton;
    private JButton subtractButton;
    private JButton multiplyButton;
    private JButton divideButton;
    private JButton clearButton;
    private BinaryCalculator calculator;

    public CalculatorGUI() {
        calculator = new BinaryCalculator();
        setupGUI();
    }

    private void setupGUI() {
        setTitle("Binary Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 5, 5, 5);

        JLabel label1 = new JLabel("First Binary Number:");
        c.gridx = 0;
        c.gridy = 0;
        add(label1, c);

        input1 = new JTextField(15);
        c.gridx = 1;
        c.gridy = 0;
        add(input1, c);

        JLabel label2 = new JLabel("Second Binary Number:");
        c.gridx = 0;
        c.gridy = 1;
        add(label2, c);

        input2 = new JTextField(15);
        c.gridx = 1;
        c.gridy = 1;
        add(input2, c);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        clearButton = new JButton("Clear");

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performCalculation("+");
            }
        });

        subtractButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performCalculation("-");
            }
        });

        multiplyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performCalculation("*");
            }
        });

        divideButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performCalculation("/");
            }
        });

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });

        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);
        buttonPanel.add(clearButton);

        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        add(buttonPanel, c);

        JLabel resultLabel = new JLabel("Result:");
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 1;
        add(resultLabel, c);

        result = new JTextField(15);
        result.setEditable(false);
        c.gridx = 1;
        c.gridy = 3;
        add(result, c);

        setVisible(true);
    }

    private void performCalculation(String operation) {
        String num1 = input1.getText();
        String num2 = input2.getText();

        if (num1.isEmpty() || num2.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both numbers");
            return;
        }

        String answer = calculator.calculate(num1, num2, operation);
        result.setText(answer);
    }

    private void clearFields() {
        input1.setText("");
        input2.setText("");
        result.setText("");
    }
}
