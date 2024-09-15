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

    public static void main(String[] args) {
        Calculator clc = new Calculator();
        clc.setVisible(true);
    }

    private double num1 = 0, num2 = 0, kq = 0;
    private char operator;
    private int operatorCount = 0;
    private boolean flag = true;

    private void taoGiaoDien() {
        JPanel p1 = new JPanel();
        p1.add(txtDisplay = new JTextField(50));
        txtDisplay.setPreferredSize(new Dimension(200, 50));
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
                            if (flag) {
                                txtDisplay.setText(txtDisplay.getText() + cmd);
                            } else {
                                txtDisplay.setText(cmd);
                                flag = true;
                            }
                        }
                        if (cmd.equals("+") || cmd.equals("-") || cmd.equals("*") || cmd.equals("/")) {
                            if (operatorCount == 0) {
                                num1 = Double.parseDouble(txtDisplay.getText());
                                operator = cmd.charAt(0);
                                txtDisplay.setText(cmd);
                                operatorCount++;
                                flag = false;
                            } else {
                                tinhToan();
                                num1 = kq;
                                operator = cmd.charAt(0);
                                txtDisplay.setText(cmd);
                                flag = false;
                            }
                        }
                        if (cmd.equals("=")) {
                            tinhToan();
                            txtDisplay.setText(String.valueOf(kq));
                            flag = false;
                            operatorCount = 0;
                        }
                        if (cmd.equals("C")) {
                            txtDisplay.setText("");
                            num1 = num2 = kq = 0;
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng thứ tự phép tính!",
                                "Chú ý", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
            );
        }

        setLayout(new BorderLayout());
        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);

    }

    public void tinhToan() {
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
    }

    public Calculator() {
        setTitle("May tinh");
        taoGiaoDien();
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
