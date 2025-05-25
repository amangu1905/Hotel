package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JTextField textfield1;
    JPasswordField pfield2;
    JButton b1, b2;

    Login() {
        super("SNAK Hotel Management Systems");

        // Set the window icon (top-left icon on the frame, taskbar icon)
        Image icon = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("icon/logo.png"));
        setIconImage(icon);

        // Username Label
        JLabel label1 = new JLabel("Username:");
        label1.setBounds(40, 20, 100, 30);
        label1.setFont(new Font("Tahoma", Font.BOLD, 16));
        label1.setForeground(Color.WHITE);
        add(label1);

        // Password Label
        JLabel label2 = new JLabel("Password:");
        label2.setBounds(40, 80, 100, 30);
        label2.setFont(new Font("Tahoma", Font.BOLD, 16));
        label2.setForeground(Color.WHITE);
        add(label2);

        // Username Field
        textfield1 = new JTextField();
        textfield1.setBounds(140, 20, 150, 30);
        textfield1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textfield1.setForeground(Color.BLACK);
        add(textfield1);

        // Password Field
        pfield2 = new JPasswordField();
        pfield2.setBounds(140, 80, 150, 30);
        pfield2.setForeground(Color.BLACK);
        add(pfield2);

        // Image on the right (Login.gif)
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/Login.gif"));
        Image i1 = imageIcon.getImage().getScaledInstance(255, 300, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(i1);
        JLabel label = new JLabel(scaledIcon);
        label.setBounds(315, -30, 255, 300);
        add(label);

        // Login Button
        b1 = new JButton("LogIn");
        b1.setBounds(60, 140, 80, 30);
        b1.setFont(new Font("Tahoma", Font.BOLD, 12));
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        add(b1);

        // Cancel Button
        b2 = new JButton("Cancel");
        b2.setBounds(150, 140, 80, 30);
        b2.setFont(new Font("Tahoma", Font.BOLD, 12));
        b2.setForeground(Color.BLACK);
        b2.addActionListener(this);
        add(b2);

        // Background and Frame Settings
        getContentPane().setBackground(new Color(12, 35, 64));
        setLayout(null);
        setLocation(400, 250);
        setSize(600, 300);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            try {
                Con c = new Con(); // your MySQL connector class
                String user = textfield1.getText();
                String pass = new String(pfield2.getPassword());

                String q = "select * from login where username ='" + user + "' and password='" + pass + "'";
                ResultSet resultset = c.statement.executeQuery(q);
                if (resultset.next()) {
                    new Dashboard(); // Ensure this class exists
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username/Password");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == b2) {
            new Dashboard(); // Ensure this class exists
            setVisible(false);

        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
