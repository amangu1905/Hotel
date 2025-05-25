package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class CheckOut extends JFrame {

    CheckOut() {
        super("SNAK Hotel Management Systems");

        // Set app icon
        Image icon = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("icon/logo.png"));
        setIconImage(icon);

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 790, 390);
        panel.setBackground(new Color(12, 35, 64));
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("Check-Out");
        label.setBounds(100, 20, 100, 30);
        label.setFont(new Font("Tahoma", Font.PLAIN, 20));
        label.setForeground(Color.WHITE);
        panel.add(label);

        JLabel userId = new JLabel("Customer Id");
        userId.setBounds(30, 80, 100, 30);
        userId.setFont(new Font("Tahoma", Font.BOLD, 14));
        userId.setForeground(Color.WHITE);
        panel.add(userId);

        Choice customer = new Choice();
        customer.setBounds(200, 80, 150, 25);
        panel.add(customer);

        JLabel roomNum = new JLabel("Room Number");
        roomNum.setBounds(30, 130, 100, 30);
        roomNum.setFont(new Font("Tahoma", Font.BOLD, 14));
        roomNum.setForeground(Color.WHITE);
        panel.add(roomNum);

        JLabel labelRoomNumber = new JLabel();
        labelRoomNumber.setBounds(200, 130, 100, 30);
        labelRoomNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelRoomNumber.setForeground(Color.WHITE);
        panel.add(labelRoomNumber);

        JLabel checkInTime = new JLabel("Check-In Time");
        checkInTime.setBounds(30, 180, 150, 30);
        checkInTime.setFont(new Font("Tahoma", Font.BOLD, 14));
        checkInTime.setForeground(Color.WHITE);
        panel.add(checkInTime);

        JLabel labelCheckInTime = new JLabel();
        labelCheckInTime.setBounds(200, 180, 200, 30);
        labelCheckInTime.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelCheckInTime.setForeground(Color.WHITE);
        panel.add(labelCheckInTime);

        JLabel checkOutTime = new JLabel("Check-Out Time");
        checkOutTime.setBounds(30, 230, 150, 30);
        checkOutTime.setFont(new Font("Tahoma", Font.BOLD, 14));
        checkOutTime.setForeground(Color.WHITE);
        panel.add(checkOutTime);

        Date date = new Date();

        JLabel labelCheckOutTime = new JLabel("" + date);
        labelCheckOutTime.setBounds(200, 230, 300, 30);
        labelCheckOutTime.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelCheckOutTime.setForeground(Color.WHITE);
        panel.add(labelCheckOutTime);

        // Fill customer choice
        try {
            Con c = new Con();
            ResultSet rs = c.statement.executeQuery("SELECT * FROM customer");
            while (rs.next()) {
                customer.add(rs.getString("number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JButton checkOut = new JButton("Check-Out");
        checkOut.setBounds(30, 300, 120, 30);
        checkOut.setForeground(Color.WHITE);
        checkOut.setBackground(Color.BLACK);
        panel.add(checkOut);

        checkOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {Con c = new Con();
                    String customerId = customer.getSelectedItem();
                    String roomNumber = labelRoomNumber.getText();
                    c.statement.executeUpdate("DELETE FROM customer WHERE number = '" + customerId + "'");
                    c.statement.executeUpdate("UPDATE room SET availability = 'Available' WHERE roomnumber = '" + roomNumber + "'");
                    JOptionPane.showMessageDialog(null, "Done");
                    setVisible(false);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton check = new JButton("Check");
        check.setBounds(300, 300, 120, 30);
        check.setForeground(Color.WHITE);
        check.setBackground(Color.BLACK);
        panel.add(check);

        check.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Con c = new Con();
                    ResultSet rs = c.statement.executeQuery("SELECT * FROM customer WHERE number = '" + customer.getSelectedItem() + "'");
                    while (rs.next()) {
                        labelRoomNumber.setText(rs.getString("room"));
                        labelCheckInTime.setText(rs.getString("checkintime"));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(170, 300, 120, 30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        panel.add(back);

        back.addActionListener(e -> setVisible(false));

        setUndecorated(true);
        setLayout(null);
        setLocation(260,100);
        setSize(850,550);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CheckOut();
    }
}
