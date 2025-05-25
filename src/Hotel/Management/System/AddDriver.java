package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddDriver extends JFrame implements ActionListener {
    JTextField nametxt, agetxt, carCt, carMt;
    JComboBox<String> gendertxt, avatxt, Ptxt, Dtxt;
    JButton add, back;

    AddDriver() {
        super("SNAK Hotel Management Systems");

        // Set app icon
        Image icon = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("icon/logo.png"));
        setIconImage(icon);

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 890, 490);
        panel.setBackground(new Color(12, 35, 64));
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("ADD DRIVERS");
        label.setBounds(200, 10, 200, 22);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Tahoma", Font.BOLD, 22));
        panel.add(label);

        JLabel name = new JLabel("Name:");
        name.setBounds(64, 70, 102, 22);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(name);

        nametxt = new JTextField();
        nametxt.setBounds(190, 70, 156, 20);
        nametxt.setForeground(Color.WHITE);
        nametxt.setFont(new Font("Tahoma", Font.BOLD, 14));
        nametxt.setBackground(new Color(16, 108, 115));
        panel.add(nametxt);

        JLabel age = new JLabel("Age:");
        age.setBounds(64, 110, 102, 22);
        age.setForeground(Color.WHITE);
        age.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(age);

        agetxt = new JTextField();
        agetxt.setBounds(190, 110, 156, 20);
        agetxt.setForeground(Color.WHITE);
        agetxt.setFont(new Font("Tahoma", Font.BOLD, 14));
        agetxt.setBackground(new Color(16, 108, 115));
        panel.add(agetxt);

        JLabel gender = new JLabel("Gender:");
        gender.setBounds(64, 150, 102, 22);
        gender.setForeground(Color.WHITE);
        gender.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(gender);

        gendertxt = new JComboBox<>(new String[]{"Male", "Female", "Others"});
        gendertxt.setBounds(190, 150, 156, 20);
        gendertxt.setForeground(Color.WHITE);
        gendertxt.setFont(new Font("Tahoma", Font.BOLD, 14));
        gendertxt.setBackground(new Color(16, 108, 115));
        panel.add(gendertxt);

        JLabel carC = new JLabel("Car Company:");
        carC.setBounds(64, 190, 102, 22);
        carC.setForeground(Color.WHITE);
        carC.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(carC);

        carCt = new JTextField();
        carCt.setBounds(190, 190, 156, 20);
        carCt.setForeground(Color.WHITE);
        carCt.setFont(new Font("Tahoma", Font.BOLD, 14));
        carCt.setBackground(new Color(16, 108, 115));
        panel.add(carCt);

        JLabel carM = new JLabel("Car Model:");
        carM.setBounds(64, 230, 102, 22);
        carM.setForeground(Color.WHITE);
        carM.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(carM);

        carMt = new JTextField();
        carMt.setBounds(190, 230, 156, 20);
        carMt.setForeground(Color.WHITE);
        carMt.setFont(new Font("Tahoma", Font.BOLD, 14));
        carMt.setBackground(new Color(16, 108, 115));
        panel.add(carMt);

        JLabel available = new JLabel("Available:");
        available.setBounds(64, 270, 102, 22);
        available.setForeground(Color.WHITE);
        available.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(available);

        avatxt = new JComboBox<>(new String[]{"Yes", "No"});
        avatxt.setBounds(190, 270, 156, 20);
        avatxt.setForeground(Color.WHITE);
        avatxt.setFont(new Font("Tahoma", Font.BOLD, 14));
        avatxt.setBackground(new Color(16, 108, 115));
        panel.add(avatxt);

        JLabel locP = new JLabel("Pickup location:");
        locP.setBounds(64, 310, 120, 22);
        locP.setForeground(Color.WHITE);
        locP.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(locP);

        Ptxt = new JComboBox<>(new String[]{"Train Station", "Airport", "ISBT", "Hotel", "Metro Station"});
        Ptxt.setBounds(190, 310, 156, 20);
        Ptxt.setForeground(Color.WHITE);
        Ptxt.setFont(new Font("Tahoma", Font.BOLD, 14));
        Ptxt.setBackground(new Color(16, 108, 115));
        panel.add(Ptxt);

        JLabel locD = new JLabel("Drop location:");
        locD.setBounds(64, 350, 120, 22);
        locD.setForeground(Color.WHITE);
        locD.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(locD);

        Dtxt = new JComboBox<>(new String[]{"Train Station", "Airport", "ISBT", "Hotel", "Metro Station"});
        Dtxt.setBounds(190, 350, 156, 20);
        Dtxt.setForeground(Color.WHITE);
        Dtxt.setFont(new Font("Tahoma", Font.BOLD, 14));
        Dtxt.setBackground(new Color(16, 108, 115));
        panel.add(Dtxt);

        add = new JButton("Add");
        add.setBounds(64, 400, 111, 33);
        add.setForeground(Color.white);
        add.setBackground(Color.BLACK);
        add.setFont(new Font("Tahoma", Font.BOLD, 14));
        add.addActionListener(this);
        panel.add(add);

        back = new JButton("Back");
        back.setBounds(180, 400, 111, 33);
        back.setForeground(Color.white);
        back.setBackground(Color.BLACK);
        back.setFont(new Font("Tahoma", Font.BOLD, 14));
        back.addActionListener(this);
        panel.add(back);

        ImageIcon imageIcon= new ImageIcon(ClassLoader.getSystemResource("icon/driver.png"));
        Image image= imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label1 = new JLabel(imageIcon1);
        label1.setBounds(500,60,300,300);
        panel.add(label1);

        setUndecorated(true);
        setLocation(20, 150);
        setLayout(null);
        setSize(900, 500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            try {
                Con c = new Con();
                String n = nametxt.getText();
                String a = agetxt.getText();
                String g = (String) gendertxt.getSelectedItem();
                String cn = carCt.getText();
                String cm = carMt.getText();
                String ava = (String) avatxt.getSelectedItem();
                String p = (String) Ptxt.getSelectedItem();
                String d = (String) Dtxt.getSelectedItem();

                String q = "insert into driver values('" + n + "','" + a + "','" + g + "','" + cn + "','" + cm + "','" + ava + "','" + p + "','" + d + "')";
                c.statement.executeUpdate(q);

                JOptionPane.showMessageDialog(null, "Driver Added Successfully");
                this.setVisible(false);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == back) {
            new Admin();
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddDriver();
    }
}
