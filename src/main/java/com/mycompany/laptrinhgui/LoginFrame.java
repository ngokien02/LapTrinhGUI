/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laptrinhgui;

import javax.swing.*;

/**
 *
 * @author Admin
 */
public class LoginFrame extends JFrame{
    
    private JLabel lbUser, lbPass;
    private JTextField txtUser;
    private JPasswordField txtPass;
    private JButton btnLogin, btnReset;

    public static void main(String[] args) {
        LoginFrame lg = new LoginFrame("Login system");
        lg.setVisible(true);
    }
    
    public LoginFrame(String title){
        super(title);
        createGUI();
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createGUI() {
        JPanel p = new JPanel();
        p.setLayout(null);
        p.add(lbUser = new JLabel("User name"));
        p.add(txtUser = new JTextField(10));
        p.add(lbPass = new JLabel("Password"));
        p.add(txtPass = new JPasswordField(10));
        p.add(btnLogin = new JButton("Login"));
        p.add(btnReset = new JButton("Reset"));
        
        lbUser.setBounds(10, 10, 100, 40);
        txtUser.setBounds(120, 10, 150, 40);
        lbPass.setBounds(10, 60, 100, 40);
        txtPass.setBounds(120, 60, 150, 40);
        btnLogin.setBounds(10, 110, 100, 40);
        btnReset.setBounds(120, 110, 100, 40);
        
        add(p);
    }
    
}
