package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class CustomerInfo extends JFrame {

    CustomerInfo() {

        super("SNAK Hotel Management Systems");

        // Set app icon
        Image icon = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("icon/logo.png"));
        setIconImage(icon);

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 890, 590);
        panel.setBackground(new Color(12, 35, 64));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10, 40, 900, 450);
        table.setBackground(new Color(12, 35, 64));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try {
            Con c = new Con(); // Make sure Con.java class exists and is correct
            String q = "select * from customer";
            ResultSet rs = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(rs)); // Make sure you have rs2xml.jar library
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel id = new JLabel("ID");
        id.setBounds(31, 11, 100, 14);
        id.setForeground(Color.WHITE);
        id.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(id);

        JLabel number = new JLabel("Number");
        number.setBounds(150, 11, 100, 14);
        number.setForeground(Color.WHITE);
        number.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(number);

        JLabel name = new JLabel("Name");
        name.setBounds(270, 11, 100, 14);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(name);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(360, 11, 100, 14);
        gender.setForeground(Color.WHITE);
        gender.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(gender);

        JLabel country = new JLabel("Country");
        country.setBounds(480, 11, 100, 25);
        country.setForeground(Color.WHITE);
        country.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(country);

        JLabel room = new JLabel("Room");
        room.setBounds(580, 11, 100, 14);
        room.setForeground(Color.WHITE);
        room.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(room);

        JLabel time = new JLabel("CI Time");
        time.setBounds(680, 11, 100, 14);
        time.setForeground(Color.WHITE);
        time.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(time);

        JLabel deposit = new JLabel("Deposit");
        deposit.setBounds(780, 11, 100, 25);
        deposit.setForeground(Color.WHITE);
        deposit.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(deposit);

        JButton back = new JButton("Back");
        back.setBounds(450, 510, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);

        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setLayout(null);
        setLocation(260,100);
        setSize(850,550);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CustomerInfo();
    }
}
