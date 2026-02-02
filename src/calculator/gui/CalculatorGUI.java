package calculator.gui;

import calculator.core.Calculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class CalculatorGUI extends JFrame {
    
    
    private JLabel display;
    private JLabel hexLabel;
    private JLabel decLabel;
    private JLabel octLabel;
    private JLabel binLabel;
    
    
    private String currentInput = "";
    private String firstNumber = "";
    private String currentOperation = "";
    
    private Calculator calculator;

    
    public CalculatorGUI() {
        calculator = new Calculator();
        setupGUI();
    }

    private void setupGUI() {
        setTitle("Calculator");
        setSize(350, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(243, 243, 243));


        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(243, 243, 243));
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 15, 5, 15));
        
        JPanel titleRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        titleRow.setBackground(new Color(243, 243, 243));
        JLabel menuIcon = new JLabel("\u2261");
        menuIcon.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        menuIcon.setForeground(Color.BLACK);
        titleRow.add(menuIcon);
        JLabel titleLabel = new JLabel("Programmer");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        titleLabel.setForeground(Color.BLACK);
        titleRow.add(titleLabel);
        topPanel.add(titleRow, BorderLayout.NORTH);

        add(topPanel, BorderLayout.NORTH);


        JPanel middlePanel = new JPanel();
        middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.Y_AXIS));
        middlePanel.setBackground(new Color(243, 243, 243));
        middlePanel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));


        display = new JLabel("0");
        display.setFont(new Font("Segoe UI Light", Font.PLAIN, 48));
        display.setForeground(Color.BLACK);
        display.setAlignmentX(Component.RIGHT_ALIGNMENT);
        JPanel displayPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        displayPanel.setBackground(new Color(243, 243, 243));
        displayPanel.add(display);
        middlePanel.add(displayPanel);

        middlePanel.add(Box.createVerticalStrut(15));

        JPanel convPanel = new JPanel(new GridLayout(4, 1, 0, 3));
        convPanel.setBackground(new Color(243, 243, 243));

        hexLabel = createConversionRow("HEX", "0", false);
        decLabel = createConversionRow("DEC", "0", false);
        octLabel = createConversionRow("OCT", "0", false);
        binLabel = createConversionRow("BIN", "0", true);

        JPanel hexRow = createConvRow("HEX", hexLabel, false);
        JPanel decRow = createConvRow("DEC", decLabel, false);
        JPanel octRow = createConvRow("OCT", octLabel, false);
        JPanel binRow = createConvRow("BIN", binLabel, true);

        convPanel.add(hexRow);
        convPanel.add(decRow);
        convPanel.add(octRow);
        convPanel.add(binRow);

        middlePanel.add(convPanel);

        middlePanel.add(Box.createVerticalStrut(10));

        JPanel qwordPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        qwordPanel.setBackground(new Color(243, 243, 243));
        JLabel gridIcon = new JLabel("::");
        gridIcon.setForeground(Color.BLACK);
        gridIcon.setFont(new Font("Segoe UI", Font.BOLD, 14));
        qwordPanel.add(gridIcon);
        JLabel settingsIcon = new JLabel("o");
        settingsIcon.setForeground(Color.BLACK);
        settingsIcon.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        qwordPanel.add(settingsIcon);
        qwordPanel.add(Box.createHorizontalStrut(20));
        JLabel qwordLabel = new JLabel("QWORD");
        qwordLabel.setForeground(Color.BLACK);
        qwordLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        qwordPanel.add(qwordLabel);
        qwordPanel.add(Box.createHorizontalStrut(40));
        JLabel msLabel = new JLabel("MS");
        msLabel.setForeground(Color.GRAY);
        msLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        qwordPanel.add(msLabel);
        qwordPanel.add(Box.createHorizontalStrut(20));
        JLabel mLabel = new JLabel("Mv");
        mLabel.setForeground(Color.GRAY);
        mLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        qwordPanel.add(mLabel);
        middlePanel.add(qwordPanel);

 
        JPanel bitwisePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        bitwisePanel.setBackground(new Color(243, 243, 243));
        JLabel bitwiseIcon = new JLabel("D>");
        bitwiseIcon.setForeground(Color.BLACK);
        bitwiseIcon.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        bitwisePanel.add(bitwiseIcon);
        JLabel bitwiseLabel = new JLabel("Bitwise v");
        bitwiseLabel.setForeground(Color.BLACK);
        bitwiseLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        bitwisePanel.add(bitwiseLabel);
        bitwisePanel.add(Box.createHorizontalStrut(15));
        JLabel bitshiftIcon = new JLabel("><");
        bitshiftIcon.setForeground(Color.BLACK);
        bitshiftIcon.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        bitwisePanel.add(bitshiftIcon);
        JLabel bitshiftLabel = new JLabel("Bit shift v");
        bitshiftLabel.setForeground(Color.BLACK);
        bitshiftLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        bitwisePanel.add(bitshiftLabel);
        middlePanel.add(bitwisePanel);

        add(middlePanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(6, 5, 2, 2));
        buttonPanel.setBackground(new Color(243, 243, 243));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 10, 5));


        addButton(buttonPanel, "A", new Color(220, 220, 220), Color.GRAY, false);
        addButton(buttonPanel, "<<", new Color(220, 220, 220), Color.BLACK, true);
        addButton(buttonPanel, ">>", new Color(220, 220, 220), Color.BLACK, true);
        addButton(buttonPanel, "C", new Color(220, 220, 220), Color.BLACK, true);
        addButton(buttonPanel, "<-", new Color(220, 220, 220), Color.BLACK, true);

        addButton(buttonPanel, "B", new Color(220, 220, 220), Color.GRAY, false);
        addButton(buttonPanel, "(", new Color(220, 220, 220), Color.BLACK, true);
        addButton(buttonPanel, ")", new Color(220, 220, 220), Color.BLACK, true);
        addButton(buttonPanel, "%", new Color(220, 220, 220), Color.BLACK, true);
        addButton(buttonPanel, "\u00F7", new Color(220, 220, 220), Color.BLACK, true);

        addButton(buttonPanel, "C", new Color(220, 220, 220), Color.GRAY, false);
        addButton(buttonPanel, "7", new Color(220, 220, 220), Color.GRAY, false);
        addButton(buttonPanel, "8", new Color(220, 220, 220), Color.GRAY, false);
        addButton(buttonPanel, "9", new Color(220, 220, 220), Color.GRAY, false);
        addButton(buttonPanel, "\u00D7", new Color(220, 220, 220), Color.BLACK, true);

        addButton(buttonPanel, "D", new Color(220, 220, 220), Color.GRAY, false);
        addButton(buttonPanel, "4", new Color(220, 220, 220), Color.GRAY, false);
        addButton(buttonPanel, "5", new Color(220, 220, 220), Color.GRAY, false);
        addButton(buttonPanel, "6", new Color(220, 220, 220), Color.GRAY, false);
        addButton(buttonPanel, "\u2212", new Color(220, 220, 220), Color.BLACK, true);

        addButton(buttonPanel, "E", new Color(220, 220, 220), Color.GRAY, false);
        addButton(buttonPanel, "1", Color.WHITE, Color.BLACK, true);
        addButton(buttonPanel, "2", new Color(220, 220, 220), Color.GRAY, false);
        addButton(buttonPanel, "3", new Color(220, 220, 220), Color.GRAY, false);
        addButton(buttonPanel, "+", new Color(220, 220, 220), Color.BLACK, true);

        addButton(buttonPanel, "F", new Color(220, 220, 220), Color.GRAY, false);
        addButton(buttonPanel, "+/-", new Color(220, 220, 220), Color.BLACK, true);
        addButton(buttonPanel, "0", Color.WHITE, Color.BLACK, true);
        addButton(buttonPanel, ".", new Color(220, 220, 220), Color.GRAY, false);
        addButton(buttonPanel, "=", new Color(72, 183, 255), Color.WHITE, true);

        add(buttonPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JLabel createConversionRow(String name, String value, boolean active) {
        JLabel label = new JLabel(value);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        label.setForeground(active ? Color.BLACK : Color.GRAY);
        return label;
    }

    private JPanel createConvRow(String name, JLabel valueLabel, boolean active) {
        JPanel row = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        row.setBackground(new Color(243, 243, 243));
        
        if (active) {
            JLabel bar = new JLabel("|");
            bar.setForeground(new Color(72, 183, 255));
            bar.setFont(new Font("Segoe UI", Font.BOLD, 14));
            row.add(bar);
        }
        
        JLabel nameLabel = new JLabel(name);
        nameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        nameLabel.setForeground(Color.BLACK);
        nameLabel.setPreferredSize(new Dimension(35, 20));
        row.add(nameLabel);
        row.add(valueLabel);
        return row;
    }

    private void addButton(JPanel panel, String text, Color bgColor, Color fgColor, boolean enabled) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        button.setBackground(bgColor);
        button.setForeground(fgColor);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setEnabled(enabled);
        button.setPreferredSize(new Dimension(60, 45));

        if (enabled) {
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    handleButton(text);
                }
            });
        }

        panel.add(button);
    }

    private void updateConversions(String binary) {
        if (binary.isEmpty() || binary.equals("0")) {
            hexLabel.setText("0");
            decLabel.setText("0");
            octLabel.setText("0");
            binLabel.setText("0");
            return;
        }
        try {
            int decimal = Integer.parseInt(binary, 2);
            hexLabel.setText(Integer.toHexString(decimal).toUpperCase());
            decLabel.setText(String.valueOf(decimal));
            octLabel.setText(Integer.toOctalString(decimal));
            binLabel.setText(binary);
        } catch (Exception e) {

        }
    }


    private void handleButton(String text) {
        
        if (text.equals("0") || text.equals("1")) {
            if (currentInput.equals("0")) {
                currentInput = text;
            } else {
                currentInput = currentInput + text;
            }
            display.setText(currentInput);
            updateConversions(currentInput);
        }
        else if (text.equals("+") || text.equals("\u2212") || text.equals("\u00D7") || text.equals("\u00F7")) {
            if (!currentInput.isEmpty()) {
                firstNumber = currentInput;
                if (text.equals("\u2212")) {
                    currentOperation = "-";
                } else if (text.equals("\u00D7")) {
                    currentOperation = "*";
                } else if (text.equals("\u00F7")) {
                    currentOperation = "/";
                } else {
                    currentOperation = text;
                }
                currentInput = "";
            }
        }
        else if (text.equals("=")) {
            if (!firstNumber.isEmpty() && !currentInput.isEmpty() && !currentOperation.isEmpty()) {
                String answer = calculator.calculate(firstNumber, currentInput, currentOperation);
                display.setText(answer);
                if (!answer.startsWith("Error")) {
                    updateConversions(answer);
                    currentInput = answer;
                } else {
                    currentInput = "";
                }
                firstNumber = "";
                currentOperation = "";
            }
        }
        else if (text.equals("C")) {
            currentInput = "";
            firstNumber = "";
            currentOperation = "";
            display.setText("0");
            updateConversions("0");
        }
        else if (text.equals("<-")) {
            if (currentInput.length() > 0) {
                currentInput = currentInput.substring(0, currentInput.length() - 1);
                if (currentInput.isEmpty()) {
                    display.setText("0");
                    updateConversions("0");
                } else {
                    display.setText(currentInput);
                    updateConversions(currentInput);
                }
            }
        }

        else if (text.equals("<<")) {
            if (!currentInput.isEmpty() && !currentInput.equals("0")) {
                currentInput = currentInput + "0";
                display.setText(currentInput);
                updateConversions(currentInput);
            }
        }
        else if (text.equals(">>")) {
            if (currentInput.length() > 1) {
                currentInput = currentInput.substring(0, currentInput.length() - 1);
                display.setText(currentInput);
                updateConversions(currentInput);
            } else if (currentInput.length() == 1) {
                currentInput = "0";
                display.setText("0");
                updateConversions("0");
            }
        }

        else if (text.equals("%")) {
            if (!currentInput.isEmpty()) {
                firstNumber = currentInput;
                currentOperation = "%";
                currentInput = "";
            }
        }
 
        else if (text.equals("+/-")) {

        }
        else if (text.equals("(") || text.equals(")")) {
        }
    }
}
