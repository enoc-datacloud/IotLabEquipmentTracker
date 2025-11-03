package com.iotlabtracking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BorrowPage extends JFrame {

    private JTextField txtRFID, txtEquipID;

    public BorrowPage() {
        setTitle("RFID Equipment Borrowing - Borrow Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(false);
        getContentPane().setBackground(new Color(245, 245, 245));
        setLayout(new BorderLayout());

        // ===== TOP NAVIGATION BAR =====
        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setBackground(new Color(25, 25, 112));
        topBar.setPreferredSize(new Dimension(0, 60));

        // --- BACK BUTTON ---
        JButton btnBack = new JButton("← Back to Dashboard");
        btnBack.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnBack.setBackground(new Color(70, 130, 180));
        btnBack.setForeground(Color.WHITE);
        btnBack.setFocusPainted(false);
        btnBack.setBorderPainted(false);
        btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnBack.setPreferredSize(new Dimension(200, 40));
        btnBack.setMargin(new Insets(5, 15, 5, 15));

        btnBack.addActionListener(e -> {
            new Dashboard().setVisible(true);
            dispose();
        });

        topBar.add(btnBack, BorderLayout.WEST);

        JLabel lblHeader = new JLabel("Borrow Equipment Page", SwingConstants.CENTER);
        lblHeader.setForeground(Color.WHITE);
        lblHeader.setFont(new Font("Segoe UI", Font.BOLD, 20));
        topBar.add(lblHeader, BorderLayout.CENTER);

        add(topBar, BorderLayout.NORTH);

        // ===== CENTER CONTENT =====
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(new Color(245, 245, 245));

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setMaximumSize(new Dimension(500, 350));

        // ===== TITLE =====
        JLabel lblTitle = new JLabel("Borrow an Equipment");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblTitle.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
        mainPanel.add(lblTitle);

        // ===== RFID FIELD =====
        JLabel lblRFID = new JLabel("RFID Tag");
        lblRFID.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblRFID.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(lblRFID);

        txtRFID = new JTextField(20);
        txtRFID.setMaximumSize(new Dimension(300, 35));
        txtRFID.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txtRFID.setHorizontalAlignment(JTextField.CENTER);
        txtRFID.setToolTipText("Enter or scan RFID tag");
        txtRFID.putClientProperty("JTextField.placeholderText", "Scan or enter RFID tag...");
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(txtRFID);

        mainPanel.add(Box.createVerticalStrut(20));

        // ===== EQUIPMENT ID FIELD =====
        JLabel lblEquip = new JLabel("Lab Equipment ID");
        lblEquip.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblEquip.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(lblEquip);

        txtEquipID = new JTextField(20);
        txtEquipID.setMaximumSize(new Dimension(300, 35));
        txtEquipID.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txtEquipID.setHorizontalAlignment(JTextField.CENTER);
        txtEquipID.setToolTipText("Enter equipment ID");
        txtEquipID.putClientProperty("JTextField.placeholderText", "Enter equipment ID...");
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(txtEquipID);

        mainPanel.add(Box.createVerticalStrut(30));

        // ===== BORROW BUTTON =====
        JButton btnBorrow = new JButton("Borrow Equipment");
        btnBorrow.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnBorrow.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnBorrow.setBackground(new Color(70, 130, 180));
        btnBorrow.setForeground(Color.WHITE);
        btnBorrow.setFocusPainted(false);
        btnBorrow.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        btnBorrow.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnBorrow.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Borrow simulated successfully!");
            new Dashboard().setVisible(true);
            dispose();
        });

        mainPanel.add(btnBorrow);
        centerPanel.add(mainPanel);
        add(centerPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BorrowPage().setVisible(true));
    }
}
