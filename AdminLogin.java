package com.iotlabtracking;

import javax.swing.*;
import java.awt.*;


public class AdminLogin extends JFrame {
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JCheckBox showPassword;

    public AdminLogin() {
        setTitle("RFID Borrowing System - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 350);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(245, 245, 245));
        panel.setLayout(null);
        getContentPane().add(panel);

        JLabel lblTitle = new JLabel("Laboratory Equipment Borrowing System");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTitle.setForeground(new Color(25, 25, 112));
        lblTitle.setBounds(40, 30, 450, 30);
        panel.add(lblTitle);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblUsername.setBounds(70, 90, 100, 25);
        panel.add(lblUsername);

        txtUsername = new JTextField();
        txtUsername.setBounds(170, 90, 200, 30);
        txtUsername.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtUsername.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        panel.add(txtUsername);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblPassword.setBounds(70, 140, 100, 25);
        panel.add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(170, 140, 200, 30);
        txtPassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtPassword.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        panel.add(txtPassword);

        showPassword = new JCheckBox("Show Password");
        showPassword.setBackground(new Color(245, 245, 245));
        showPassword.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        showPassword.setBounds(170, 175, 150, 25);
        panel.add(showPassword);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(170, 220, 100, 35);
        btnLogin.setBackground(new Color(70, 130, 180));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFocusPainted(false);
        btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnLogin.setBorderPainted(false);
        btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(btnLogin);

        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(280, 220, 90, 35);
        btnExit.setBackground(new Color(220, 20, 60));
        btnExit.setForeground(Color.WHITE);
        btnExit.setFocusPainted(false);
        btnExit.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnExit.setBorderPainted(false);
        btnExit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(btnExit);

        // ===== EVENT HANDLERS =====

        // Toggle password visibility
        showPassword.addActionListener(e -> {
            if (showPassword.isSelected()) {
                txtPassword.setEchoChar((char) 0);
            } else {
                txtPassword.setEchoChar('•');
            }
        });

        // Login button
        btnLogin.addActionListener(e -> {
            String username = txtUsername.getText();
            String password = new String(txtPassword.getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (username.equals("admin") && password.equals("admin123")) { // temporary login
                JOptionPane.showMessageDialog(this, "Login Successful! Welcome, " + username + ".");
                new Dashboard().setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid credentials.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Exit button
        btnExit.addActionListener(e -> System.exit(0));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AdminLogin().setVisible(true));
    }
}
