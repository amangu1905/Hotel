package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ManagerInfo extends JFrame {
    ManagerInfo(){
        super("SNAK Hotel Management Systems");

        // Set app icon
        Image icon = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("icon/logo.png"));
        setIconImage(icon);

        // Panel setup
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 990, 590);
        panel.setBackground(new Color(12, 35, 64));
        panel.setLayout(null);
        add(panel);

        // Table inside scroll pane
        JTable table = new JTable();
        table.setForeground(Color.WHITE);
        table.setBackground(new Color(12, 35, 64));

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBackground(new Color(12,35,64));
        scrollPane.setBounds(10, 34, 980, 450);
        panel.add(scrollPane);

        // Load data from database
        try {
            Con c = new Con(); // Your custom DB connection class
            String EmployeeSQL = "SELECT * FROM Employee where job='Manager'";
            ResultSet resultSet = c.statement.executeQuery(EmployeeSQL);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // BACK Button
        JButton back = new JButton("BACK");
        back.setBounds(350, 500, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        // Labels
        String[] labels = {"Name", "Age", "Gender", "Job", "Salary", "Phone", "Email", "ID Number"};
        int[] xPositions = {41, 159, 273, 416, 536, 656, 786, 896};

        for (int i = 0; i < labels.length; i++) {
            JLabel label = new JLabel(labels[i]);
            label.setBounds(xPositions[i], 11, 70, 19);
            label.setForeground(Color.WHITE);
            label.setBackground(new Color(12,35,64));
            label.setFont(new Font("Tahoma", Font.BOLD, 14));
            panel.add(label);
        }

        // Frame setup
        setUndecorated(true);
        setLayout(null);
        setLocation(260,100);
        setSize(850,550);
        setVisible(true);


    }
    public static void main(String[] args) {
        new ManagerInfo();
    }
}
