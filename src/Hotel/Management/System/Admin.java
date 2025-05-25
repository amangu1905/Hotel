package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin extends JFrame implements ActionListener {
    JButton add_Employee, add_Room, add_Drivers, logout, back;

    Admin() {
        super("SNAK Hotel Management Systems");

        // Get screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;

        setSize(width, height);
        setLayout(null);

        Image icon = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("icon/logo.png"));
        setIconImage(icon);

        int baseX = width / 8;
        int buttonWidth = width / 6;
        int buttonHeight = height / 30;
        int imageSize = height / 9;

        // Add Employee
        add_Employee = new JButton("ADD EMPLOYEE");
        add_Employee.setBounds(baseX + 180, height / 3, buttonWidth, buttonHeight);
        add_Employee.setBackground(Color.WHITE);
        add_Employee.setForeground(Color.BLACK);
        add_Employee.setFont(new Font("Tahoma", Font.BOLD, 15));
        add_Employee.addActionListener(this);
        add(add_Employee);

        ImageIcon empIcon = new ImageIcon(ClassLoader.getSystemResource("icon/employees.png"));
        Image empImg = empIcon.getImage().getScaledInstance(imageSize, imageSize, Image.SCALE_DEFAULT);
        JLabel empLabel = new JLabel(new ImageIcon(empImg));
        empLabel.setBounds(baseX, height / 3 - imageSize / 3, imageSize, imageSize);
        add(empLabel);

        // Add Room
        add_Room = new JButton("ADD ROOM");
        add_Room.setBounds(baseX + 180, height / 2, buttonWidth, buttonHeight);
        add_Room.setBackground(Color.WHITE);
        add_Room.setForeground(Color.BLACK);
        add_Room.setFont(new Font("Tahoma", Font.BOLD, 15));
        add_Room.addActionListener(this);
        add(add_Room);

        ImageIcon roomIcon = new ImageIcon(ClassLoader.getSystemResource("icon/room.png"));
        Image roomImg = roomIcon.getImage().getScaledInstance(imageSize, imageSize, Image.SCALE_DEFAULT);
        JLabel roomLabel = new JLabel(new ImageIcon(roomImg));
        roomLabel.setBounds(baseX, height / 2 - imageSize / 3, imageSize, imageSize);
        add(roomLabel);

        // Add Drivers
        add_Drivers = new JButton("ADD DRIVER");
        add_Drivers.setBounds(baseX + 180, (int)(height * 0.65), buttonWidth , buttonHeight);
        add_Drivers.setBackground(Color.WHITE);
        add_Drivers.setForeground(Color.BLACK);
        add_Drivers.setFont(new Font("Tahoma", Font.BOLD, 15));
        add_Drivers.addActionListener(this);
        add(add_Drivers);

        ImageIcon driverIcon = new ImageIcon(ClassLoader.getSystemResource("icon/driver.png"));
        Image driverImg = driverIcon.getImage().getScaledInstance(imageSize, imageSize, Image.SCALE_DEFAULT);
        JLabel driverLabel = new JLabel(new ImageIcon(driverImg));
        driverLabel.setBounds(baseX, (int)(height * 0.65) - imageSize / 3, imageSize, imageSize);
        add(driverLabel);

        // Big Logo
        ImageIcon logoIcon = new ImageIcon(ClassLoader.getSystemResource("icon/logo.png"));
        Image logoImg = logoIcon.getImage().getScaledInstance(width / 5, width / 5, Image.SCALE_DEFAULT);
        JLabel logoLabel = new JLabel(new ImageIcon(logoImg));
        logoLabel.setBounds((int)(width * 0.7), height / 4, width / 5, width / 5);
        add(logoLabel);

        // Logout Button
        logout = new JButton("LOG OUT");
        logout.setBounds(10, height - 80, buttonWidth / 2, buttonHeight);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.setFont(new Font("Tahoma", Font.BOLD, 15));
        logout.addActionListener(this);
        add(logout);

        // Back Button
        back = new JButton("BACK");
        back.setBounds(120, height - 80, buttonWidth, buttonHeight);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma", Font.BOLD, 15));
        back.addActionListener(this);
        add(back);

        getContentPane().setBackground(new Color(12, 35, 64));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add_Employee) {
            new AddEmployee();
            // Action
        } else if (e.getSource() == add_Room) {
            new AddRoom();
            // Action
        } else if (e.getSource() == add_Drivers) {
            new AddDriver();
            // Action
        } else if (e.getSource() == logout) {
            System.exit(102);
        } else {
            new Dashboard();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Admin();
    }
}
