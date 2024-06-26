package kalkulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Kalkulator extends JFrame implements ActionListener {
    private JTextField numField1, numField2, resultField;
    private JButton addButton, subButton, mulButton, divButton, modButton;

    public Kalkulator() {
        setTitle("Simple Calculator");
        setSize(300, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2));

        JLabel numLabel1 = new JLabel("Number 1:");
        numField1 = new JTextField();
        JLabel numLabel2 = new JLabel("Number 2:");
        numField2 = new JTextField();
        JLabel resultLabel = new JLabel("Result:");
        resultField = new JTextField();
        resultField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        modButton = new JButton("%");

        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);
        modButton.addActionListener(this);

        add(numLabel1);
        add(numField1);
        add(numLabel2);
        add(numField2);
        add(resultLabel);
        add(resultField);
        add(addButton);
        add(subButton);
        add(mulButton);
        add(divButton);
        add(modButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int num1 = Integer.parseInt(numField1.getText());
            int num2 = Integer.parseInt(numField2.getText());
            int result = 0;

            if (e.getSource() == addButton) {
                result = num1 + num2;
            } else if (e.getSource() == subButton) {
                result = num1 - num2;
            } else if (e.getSource() == mulButton) {
                result = num1 * num2;
            } else if (e.getSource() == divButton) {
                result = num1 / num2;
            } else if (e.getSource() == modButton) {
                result = num1 % num2;
            }

            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid integers.");
        } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(this, "Cannot divide by zero.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Kalkulator();
            }
        });
    }
}