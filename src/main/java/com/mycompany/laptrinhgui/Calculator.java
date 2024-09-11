/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laptrinhgui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Admin
 */
public class Calculator extends JFrame {

    private JTextField txtDisplay;
    private JButton[] bt = new JButton[17];
    private String[] str = {"C", "7", "8", "9", "+",
        "4", "5", "6", "-",
        "1", "2", "3", "*",
        "0", ".", "=", "/"};

    private double num1, num2;
    private char operator;
    private int operatorCount = 0;
    private double kq;

    public static void main(String[] args) {
        Calculator clc = new Calculator();
        clc.setVisible(true);
    }

    private void taoGiaoDien() {
        JPanel p1 = new JPanel();
        p1.add(txtDisplay = new JTextField(50));
        txtDisplay.setPreferredSize(new Dimension(200, 50));
        txtDisplay.setEditable(false);
//        p1.add(btClear = new JButton("C"));

        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(4, 4, 5, 5));
        for (int i = 0; i < bt.length; i++) {
            bt[i] = new JButton(str[i]);
            if (i == 0) {
                p1.add(bt[i]);
            } else {
                p2.add(bt[i]);
            }

            bt[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String cmd = e.getActionCommand();
                    try {
                        if (cmd.charAt(0) >= '0' && cmd.charAt(0) <= '9' || cmd.equals(".")) {
                            txtDisplay.setText(txtDisplay.getText() + e.getActionCommand());
                        }
                        if (cmd.equals("+") || cmd.equals("-") || cmd.equals("*") || cmd.equals("/")) {
                            if (operatorCount == 0) {
                                num1 = Double.parseDouble(txtDisplay.getText());
                                operator = cmd.charAt(0);
                                txtDisplay.setText("");
                                operatorCount++;
                            } else {
                                ketQua();
                            }
                        }
                        if(cmd.equals("=")){
                            ketQua();
                        }
                        if (cmd.equals("C")) {
                            txtDisplay.setText("");
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng thứ tự phép tính!", "Chú ý", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
            );
        }

        setLayout(new BorderLayout());
        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);

    }

    public void ketQua() {
        num2 = Double.parseDouble(txtDisplay.getText());
        switch (operator) {
            case '+':
                kq = num1 + num2;
                break;
            case '-':
                kq = num1 - num2;
                break;
            case '*':
                kq = num1 * num2;
                break;
            case '/':
                kq = num1 / num2;
                break;
        }
        txtDisplay.setText(String.valueOf(kq));
        operatorCount = 0;
    }

    public Calculator() {
        setTitle("May tinh");
        taoGiaoDien();
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
