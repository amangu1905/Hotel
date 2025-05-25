package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Department extends JFrame {

    Department() {
        super("SNAK Hotel Management Systems");

        // Set app icon
        Image icon = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("icon/logo.png"));
        setIconImage(icon);



        JPanel panel = new JPanel();
        panel.setBackground(new Color(12, 35, 64));
        panel.setBounds(5, 5, 690, 450);
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(8, 40, 660, 350);
        table.setBackground(new Color(12, 35, 64));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try {
            Con c = new Con(); // assuming you have a class named 'con' that sets up DB connection
            String departmentInfo = "SELECT * FROM department";
            ResultSet rs = c.statement.executeQuery(departmentInfo);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JButton back = new JButton("Back");
        back.setBounds(400, 410, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);

        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        JLabel label1 = new JLabel("Department");
        label1.setBounds(145, 11, 105, 20);
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label1);

        JLabel label2 = new JLabel("Budget");
        label2.setBounds(431, 11, 105, 20);
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label2);

        setUndecorated(true);
        setLayout(null);
        setLocation(260,100);
        setSize(850,550);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Department();
    }
}
