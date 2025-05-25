package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reception extends JFrame {

    public Reception() {
        super("SNAK Hotel Management Systems");

        // Set app icon
        Image icon = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("icon/logo.png"));
        setIconImage(icon);

        // Full screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Sidebar panel
        JPanel sidebar = new JPanel();
        sidebar.setBackground(new Color(12, 35, 64));
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setPreferredSize(new Dimension(270, screenSize.height));
        add(sidebar, BorderLayout.WEST);

        // Button labels
        String[] buttonLabels = {
                "New Customer Form", "Room", "Department", "ALL Employee",
                "Customer INFO", "Manager INFO", "Update Check-IN Details",
                "Update Room Status", "Pickup Service", "Check Out"
        };

        // Add buttons with action listeners
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setMaximumSize(new Dimension(230, 30));
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            button.setBackground(Color.BLACK);
            button.setForeground(Color.WHITE);
            sidebar.add(Box.createVerticalStrut(15));
            sidebar.add(button);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (label.equals("New Customer Form")) {
                        new NewCustomer();
                        // new NewCustomer();
                    } else if (label.equals("Room")) {
                        new Room();
                        // new Room();
                    } else if (label.equals("Department")) {
                        new Department();
                        // new Department();
                    } else if (label.equals("ALL Employee")) {
                        new Employee();
                        // new AllEmployee();
                    } else if (label.equals("Customer INFO")) {
                        new CustomerInfo();
                        // new CustomerInfo();
                    } else if (label.equals("Manager INFO")) {
                        new ManagerInfo();
                        // new ManagerInfo();
                    } else if (label.equals("Update Check-IN Details")) {
                        JOptionPane.showMessageDialog(null, "Update Check-IN Details clicked");
                        // new UpdateCheckIn();
                    } else if (label.equals("Update Room Status")) {
                        JOptionPane.showMessageDialog(null, "Update Room Status clicked");
                        // new UpdateRoomStatus();
                    } else if (label.equals("Pickup Service")) {
                        JOptionPane.showMessageDialog(null, "Pickup Service clicked");
                        // new PickupService();
                    } else if (label.equals("Check Out")) {
                        new CheckOut();
                        // new CheckOut();
                    } else {
                        JOptionPane.showMessageDialog(null, "No action assigned.");
                    }
                }
            });
        }

        // Add animated GIF at the bottom
        sidebar.add(Box.createVerticalGlue());
        ImageIcon gifIcon = new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("icon/login.gif"))
                .getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT));
        JLabel gifLabel = new JLabel(gifIcon);
        gifLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        sidebar.add(Box.createVerticalStrut(20));
        sidebar.add(gifLabel);
        sidebar.add(Box.createVerticalStrut(20));

        // Main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(12, 35, 64));
        add(mainPanel, BorderLayout.CENTER);

        ImageIcon mainGif = new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("icon/cccc.gif"))
                .getImage().getScaledInstance(900, 800, Image.SCALE_SMOOTH));
        JLabel mainLabel = new JLabel(mainGif);
        mainLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(mainLabel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Reception();
    }
}
