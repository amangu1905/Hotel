package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener {

    JTextField nametxt, agetxt, salText, phoneText, idText, emailText;
    JComboBox<String> gendertxt, comboBox;
    JButton add, back;

    AddEmployee() {

        super("SNAK Hotel Management Systems");

        // Set app icon
        Image icon = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("icon/logo.png"));
        setIconImage(icon);

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 890, 498);
        panel.setLayout(null);
        panel.setBackground(new Color(12, 35, 64));
        add(panel);

        JLabel name = new JLabel("NAME:");
        name.setBounds(60, 30, 150, 27);
        name.setFont(new Font("serif", Font.BOLD, 17));
        name.setForeground(Color.WHITE);
        panel.add(name);

        nametxt = new JTextField();
        nametxt.setBounds(200, 30, 150, 27);
        nametxt.setBackground(new Color(16, 108, 115));
        nametxt.setFont(new Font("Tahoma", Font.BOLD, 14));
        nametxt.setForeground(Color.WHITE);
        panel.add(nametxt);

        JLabel age = new JLabel("AGE:");
        age.setBounds(60, 80, 150, 27);
        age.setFont(new Font("serif", Font.BOLD, 17));
        age.setForeground(Color.WHITE);
        panel.add(age);

        agetxt = new JTextField();
        agetxt.setBounds(200, 80, 150, 27);
        agetxt.setBackground(new Color(16, 108, 115));
        agetxt.setFont(new Font("Tahoma", Font.BOLD, 14));
        agetxt.setForeground(Color.WHITE);
        panel.add(agetxt);

        JLabel gender = new JLabel("GENDER:");
        gender.setBounds(60, 130, 150, 27);
        gender.setFont(new Font("serif", Font.BOLD, 17));
        gender.setForeground(Color.WHITE);
        panel.add(gender);

        gendertxt = new JComboBox<>(new String[] { "Male", "Female", "Others" });
        gendertxt.setBounds(200, 130, 150, 27);
        gendertxt.setBackground(new Color(16, 108, 115));
        gendertxt.setFont(new Font("Tahoma", Font.BOLD, 14));
        gendertxt.setForeground(Color.WHITE);
        panel.add(gendertxt);

        JLabel job = new JLabel("JOB:");
        job.setBounds(60, 170, 150, 27);
        job.setFont(new Font("serif", Font.BOLD, 17));
        job.setForeground(Color.WHITE);
        panel.add(job);

        comboBox = new JComboBox<>(new String[] { "Front Desk", "Housekeeping", "Kitchen Staff", "Room Service", "Manager", "Accountant", "Chef" });
        comboBox.setBounds(200, 170, 150, 30);
        comboBox.setBackground(new Color(16, 108, 115));
        comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        comboBox.setForeground(Color.WHITE);
        panel.add(comboBox);

        JLabel salary = new JLabel("SALARY:");
        salary.setBounds(60, 210, 150, 27);
        salary.setFont(new Font("serif", Font.BOLD, 17));
        salary.setForeground(Color.WHITE);
        panel.add(salary);

        salText = new JTextField();
        salText.setBounds(200, 210, 150, 27);
        salText.setBackground(new Color(16, 108, 115));
        salText.setFont(new Font("Tahoma", Font.BOLD, 14));
        salText.setForeground(Color.WHITE);
        panel.add(salText);

        JLabel phone = new JLabel("PHONE NO:");
        phone.setBounds(60, 250, 150, 27);
        phone.setFont(new Font("serif", Font.BOLD, 17));
        phone.setForeground(Color.WHITE);
        panel.add(phone);

        phoneText = new JTextField();
        phoneText.setBounds(200, 250, 150, 27);
        phoneText.setBackground(new Color(16, 108, 115));
        phoneText.setFont(new Font("Tahoma", Font.BOLD, 14));
        phoneText.setForeground(Color.WHITE);
        panel.add(phoneText);

        JLabel id = new JLabel("ID NUMBER:");
        id.setBounds(60, 290, 150, 27);
        id.setFont(new Font("serif", Font.BOLD, 17));
        id.setForeground(Color.WHITE);
        panel.add(id);

        idText = new JTextField();
        idText.setBounds(200, 290, 150, 27);
        idText.setBackground(new Color(16, 108, 115));
        idText.setFont(new Font("Tahoma", Font.BOLD, 14));
        idText.setForeground(Color.WHITE);
        panel.add(idText);

        JLabel email = new JLabel("E-MAIL:");
        email.setBounds(60, 330, 150, 27);
        email.setFont(new Font("serif", Font.BOLD, 17));
        email.setForeground(Color.WHITE);
        panel.add(email);

        emailText = new JTextField();
        emailText.setBounds(200, 330, 150, 27);
        emailText.setBackground(new Color(16, 108, 115));
        emailText.setFont(new Font("Tahoma", Font.BOLD, 14));
        emailText.setForeground(Color.WHITE);
        panel.add(emailText);

        JLabel AED = new JLabel("ADD EMPLOYEE DETAILS");
        AED.setBounds(450, 25, 445, 35);
        AED.setFont(new Font("serif", Font.BOLD, 31));
        AED.setForeground(Color.WHITE);
        panel.add(AED);

        add = new JButton("ADD");
        add.setBounds(80, 420, 100, 30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        panel.add(add);
        add.addActionListener(this);

        back = new JButton("BACK");
        back.setBounds(200, 420, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(this);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/addemp.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(500, 100, 300, 300);
        panel.add(label);

        setUndecorated(true);
        setLocation(25, 50);
        setLayout(null);
        setSize(900, 500);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String name = nametxt.getText();
            String age = agetxt.getText();
            String salary = salText.getText();
            String phone = phoneText.getText();
            String email = emailText.getText();
            String id = idText.getText();
            String job = (String) comboBox.getSelectedItem();
            String gender = (String) gendertxt.getSelectedItem();

            try {
                Con c = new Con();
                String str = "insert into employee values('" + name + "','" + age + "','" + gender + "','" + job + "','" + salary + "','" + phone + "','" + email + "','" + id + "')";
                c.statement.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Employee Added");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            new Admin();
        }
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
