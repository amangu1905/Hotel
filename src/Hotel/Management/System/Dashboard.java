package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {
    JButton adminButton, receptionButton;

    Dashboard() {
        super("SNAK HOTEL MANAGEMENT SYSTEMS");

        // Get screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;

        setSize(width, height);
        setLayout(null);

        // Set icon
        Image icon = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("icon/logo.png"));
        setIconImage(icon);

        // Reception Image and Button
        ImageIcon receptionImg = new ImageIcon(ClassLoader.getSystemResource("icon/Reception.png"));
        Image receptionScaled = receptionImg.getImage().getScaledInstance(width / 8, height / 5, Image.SCALE_SMOOTH);
        JLabel receptionLabel = new JLabel(new ImageIcon(receptionScaled));
        int receptionX = width / 4 - width / 16;
        int receptionY = height / 2 - height / 5;
        receptionLabel.setBounds(receptionX, receptionY, width / 8, height / 5);
        add(receptionLabel);

        receptionButton = new JButton("Reception");
        receptionButton.setBounds(receptionX, receptionY + height / 5 + 20, width / 8, 35);
        receptionButton.setFont(new Font("Tahoma", Font.BOLD, 16));
        receptionButton.setBackground(new Color(255, 98, 0));
        receptionButton.setForeground(Color.white);
        receptionButton.addActionListener(this);
        add(receptionButton);

        // Admin Image and Button
        ImageIcon adminImg = new ImageIcon(ClassLoader.getSystemResource("icon/boss.png"));
        Image adminScaled = adminImg.getImage().getScaledInstance(width / 8, height / 5, Image.SCALE_SMOOTH);
        JLabel adminLabel = new JLabel(new ImageIcon(adminScaled));
        int adminX = width * 3 / 4 - width / 16;
        int adminY = height / 2 - height / 5;
        adminLabel.setBounds(adminX, adminY, width / 8, height / 5);
        add(adminLabel);

        adminButton = new JButton("Admin");
        adminButton.setBounds(adminX, adminY + height / 5 + 20, width / 8, 35);
        adminButton.setFont(new Font("Tahoma", Font.BOLD, 16));
        adminButton.setBackground(new Color(255, 98, 0));
        adminButton.setForeground(Color.white);
        adminButton.addActionListener(this);
        add(adminButton);

        // Background image
        ImageIcon bgIcon = new ImageIcon(ClassLoader.getSystemResource("icon/Dashboard.gif"));
        Image bgScaled = bgIcon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);
        JLabel bgLabel = new JLabel(new ImageIcon(bgScaled));
        bgLabel.setBounds(0, 0, width, height);
        add(bgLabel);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == receptionButton) {
            new Reception();
            this.setVisible(false);
            // Add Reception window logic
        } else if (e.getSource() == adminButton) {
            new Login2();
            this.setVisible(false);
            // Add Admin window logic
        }
    }

    public static void main(String[] args) {
        new Dashboard();
    }
}
