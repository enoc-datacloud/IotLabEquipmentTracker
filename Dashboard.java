package com.iotlabtracking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame {

    public Dashboard() {
        setTitle("RFID Equipment Borrowing System - Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make it open in full screen by default
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(false);
        getContentPane().setLayout(new BorderLayout());

        // ===== NAVIGATION BAR =====
        JPanel navBar = new JPanel();
        navBar.setBackground(new Color(25, 25, 112)); 
        navBar.setPreferredSize(new Dimension(getWidth(), 80)); 
        navBar.setLayout(null);

        JLabel lblTitle = new JLabel("RFID Borrowing System");
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 28)); 
        lblTitle.setBounds(50, 20, 500, 40);
        navBar.add(lblTitle);

        JButton btnBorrow = new JButton("Borrow");
        btnBorrow.setBounds(1150, 25, 120, 35);
        styleNavButton(btnBorrow);
        navBar.add(btnBorrow);

        JButton btnReturn = new JButton("Return");
        btnReturn.setBounds(1290, 25, 120, 35);
        styleNavButton(btnReturn);
        navBar.add(btnReturn);

        JButton btnBack = new JButton("Logout");
        btnBack.setBounds(1430, 25, 120, 35);
        styleNavButton(btnBack);
        navBar.add(btnBack);

        getContentPane().add(navBar, BorderLayout.NORTH);

        // ===== MAIN CONTENT =====
        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setBackground(new Color(245, 245, 245));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setBackground(new Color(245, 245, 245));

        JLabel lblWelcome = new JLabel("Welcome, User!");
        lblWelcome.setFont(new Font("Segoe UI", Font.BOLD, 40)); 
        lblWelcome.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblWelcome.setBorder(BorderFactory.createEmptyBorder(20, 0, 25, 0));
        textPanel.add(lblWelcome);

        JLabel lblDesc = new JLabel("<html><div style='text-align: center; width: 800px;'>"
                + "Easily borrow and return laboratory equipment using RFID technology. "
                + "Simply scan your RFID tag to manage borrowing records and ensure efficient inventory tracking."
                + "</div></html>");
        lblDesc.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        lblDesc.setAlignmentX(Component.CENTER_ALIGNMENT);
        textPanel.add(lblDesc);

        contentPanel.add(textPanel, gbc);
        getContentPane().add(contentPanel, BorderLayout.CENTER);

        // ===== BUTTON ACTIONS =====
        btnBorrow.addActionListener(e -> {
            new BorrowPage().setVisible(true);
            dispose();
        });

        btnReturn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ReturnPage().setVisible(true);  
                dispose();                          
            }
        });

        btnBack.addActionListener(e -> {
        
            dispose();
        });
    }

    private void styleNavButton(JButton btn) {
        btn.setFocusPainted(false);
        btn.setBackground(new Color(70, 130, 180));
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btn.setBorderPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Dashboard().setVisible(true));
    }
}
