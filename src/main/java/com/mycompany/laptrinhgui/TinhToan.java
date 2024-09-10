/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
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
public class TinhToan extends JFrame {

    private JLabel lb1, lb2, lb3;
    private JTextField txt1, txt2, txtKQ;
    private JButton btCong, btTru, btNhan, btChia;

    public static void main(String[] args) {
        TinhToan t = new TinhToan();
        t.setVisible(true);
    }

    public TinhToan() {
        setTitle("Tinh toan don gian");
        taoGiaoDien();
        pack();
//        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void taoGiaoDien() {
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(3, 2, 5, 5));
        p1.add(lb1 = new JLabel("So thu 1"));
        p1.add(txt1 = new JTextField());
        txt1.setPreferredSize(new Dimension(100, 30));
        p1.add(lb2 = new JLabel("So thu 2"));
        p1.add(txt2 = new JTextField());
        p1.add(lb3 = new JLabel("Ket qua"));
        p1.add(txtKQ = new JTextField());

        JPanel p2 = new JPanel();
        p2.add(btCong = new JButton("Cong"));
        btCong.setPreferredSize(new Dimension(70, 30));
        p2.add(btTru = new JButton("Tru"));
        p2.add(btNhan = new JButton("Nhan"));
        p2.add(btChia = new JButton("Chia"));

        setLayout(new BorderLayout());
        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);

        btCong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double x = Double.parseDouble(txt1.getText());
                double y = Double.parseDouble(txt2.getText());
                double kq = x + y;
                txtKQ.setText(String.valueOf(kq));
            }
        });
        
        btTru.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double x = Double.parseDouble(txt1.getText());
                double y = Double.parseDouble(txt2.getText());
                double kq = x - y;
                txtKQ.setText(String.valueOf(kq));
            }
        });
        
        btNhan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double x = Double.parseDouble(txt1.getText());
                double y = Double.parseDouble(txt2.getText());
                double kq = x * y;
                txtKQ.setText(String.valueOf(kq));
            }
        });
        
        btChia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double x = Double.parseDouble(txt1.getText());
                double y = Double.parseDouble(txt2.getText());
                double kq = x / y;
                txtKQ.setText(String.valueOf(kq));
            }
        });
    }
}
