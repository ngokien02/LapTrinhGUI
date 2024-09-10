/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laptrinhgui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Admin
 */
public class Calculator extends JFrame {

    private JTextField txtDisplay;
    private JButton btClear;
    private JButton[] bt = new JButton[16];
    private String[] str = {"7","8","9","+","4","5","6","-","1","2","3","*","0",".","=","/"};
    
    public static void main(String[] args) {
        Calculator clc = new Calculator();
        clc.setVisible(true);
    }
    
    private void taoGiaoDien(){
        JPanel p1 = new JPanel();
        p1.add(txtDisplay = new JTextField(50));
        txtDisplay.setPreferredSize(new Dimension(200, 30));
        txtDisplay.setEditable(false);
        p1.add(btClear = new JButton("C"));
        
        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(4,4,5,5));
        for(int i = 0; i < bt.length; i++){
            bt[i] = new JButton(str[i]);
            p2.add(bt[i]);
            
            bt[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    txtDisplay.setText(txtDisplay.getText() + e.getActionCommand());
                }
            });
        }
        
        setLayout(new BorderLayout());
        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);
        
        btClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtDisplay.setText("");
            }
        });
        
    }
    
    public Calculator(){
        setTitle("May tinh");
        taoGiaoDien();
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
