package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.ResultSet;

public class NewCustomer extends JFrame implements ActionListener {

    JComboBox comboBox,gender ;
    JTextField idtxt,ntxt,nametxt,ctxt,dtxt;
    Choice c1;
    JLabel date;
    JButton add,back;

    NewCustomer(){

        super("SNAK Hotel Management Systems");

        // Set app icon
        Image icon = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("icon/logo.png"));
        setIconImage(icon);

        JPanel panel = new JPanel();
        panel.setBounds(5,5,840,540);
        panel.setLayout(null);
        panel.setBackground(new Color(12,35,64));
        add(panel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/customer.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(550, 150, 200, 200);
        panel.add(label);

        JLabel NCF = new JLabel("NEW CUSTOMER FORM");
        NCF.setBounds(200, 25, 445, 35);
        NCF.setFont(new Font("serif", Font.BOLD, 31));
        NCF.setForeground(Color.WHITE);
        panel.add(NCF);

        JLabel id = new JLabel("ID TYPE:");
        id.setBounds(35, 76, 200, 14);
        id.setFont(new Font("Tahoma", Font.BOLD, 14));
        id.setForeground(Color.WHITE);
        panel.add(id);
        comboBox = new JComboBox(new String[]{"Passport","Aadhar Card","Voter Id","Driving License"});
        comboBox.setBounds(271, 76, 200, 20);
        comboBox.setBackground(new Color(12,35,64));
        comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        comboBox.setForeground(Color.white);
        panel.add(comboBox);

        JLabel idn = new JLabel("ID Number:");
        idn.setBounds(35, 111, 200, 14);
        idn.setFont(new Font("Tahoma", Font.BOLD, 14));
        idn.setForeground(Color.WHITE);
        panel.add(idn);
        idtxt = new JTextField();
        idtxt.setBounds(271, 111, 200, 20);
        idtxt.setBackground(new Color(12,35,64));
        idtxt.setFont(new Font("Tahoma", Font.BOLD, 14));
        idtxt.setForeground(Color.white);
        panel.add(idtxt);

        JLabel name = new JLabel("Name:");
        name.setBounds(35, 146, 200, 14);
        name.setFont(new Font("Tahoma", Font.BOLD, 14));
        name.setForeground(Color.WHITE);
        panel.add(name);
        nametxt = new JTextField();
        nametxt.setBounds(271, 146, 200, 20);
        nametxt.setBackground(new Color(12,35,64));
        nametxt.setFont(new Font("Tahoma", Font.BOLD, 14));
        nametxt.setForeground(Color.white);
        panel.add(nametxt);

        JLabel gen = new JLabel("Gender:");
        gen.setBounds(35, 181, 200, 14);
        gen.setFont(new Font("Tahoma", Font.BOLD, 14));
        gen.setForeground(Color.WHITE);
        panel.add(gen);
        gender = new JComboBox(new String[]{"Male","Female","Others"});
        gender.setBounds(271, 181, 200, 20);
        gender.setBackground(new Color(12,35,64));
        gender.setFont(new Font("Tahoma", Font.BOLD, 14));
        gender.setForeground(Color.white);
        panel.add(gender);

        JLabel n = new JLabel("Number:");
        n.setBounds(35, 216, 200, 14);
        n.setFont(new Font("Tahoma", Font.BOLD, 14));
        n.setForeground(Color.WHITE);
        panel.add(n);
        ntxt = new JTextField();
        ntxt.setBounds(271, 216, 200, 20);
        ntxt.setBackground(new Color(12,35,64));
        ntxt.setFont(new Font("Tahoma", Font.BOLD, 14));
        ntxt.setForeground(Color.white);
        panel.add(ntxt);

        JLabel c = new JLabel("Country:");
        c.setBounds(35, 251, 200, 14);
        c.setFont(new Font("Tahoma", Font.BOLD, 14));
        c.setForeground(Color.WHITE);
        panel.add(c);
        ctxt = new JTextField();
        ctxt.setBounds(271, 251, 200, 20);
        ctxt.setBackground(new Color(12,35,64));
        ctxt.setFont(new Font("Tahoma", Font.BOLD, 14));
        ctxt.setForeground(Color.white);
        panel.add(ctxt);

        JLabel room = new JLabel("Allocated Room No:");
        room.setBounds(35, 286, 235, 14);
        room.setFont(new Font("Tahoma", Font.BOLD, 14));
        room.setForeground(Color.WHITE);
        panel.add(room);
        c1 = new Choice();
        try{
            Con con = new Con();
            ResultSet resultSet=con.statement.executeQuery("select*from room");
            while(resultSet.next()){
                c1.add(resultSet.getString("roomnumber"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        c1.setBounds(271,286,200,20);
        c1.setFont(new Font("Tahoma",Font.BOLD,14));
        c1.setBackground(new Color(12,35,64));
        c1.setForeground(Color.WHITE);
        panel.add(c1);

        JLabel CIS  = new JLabel("Checked-IN:");
        CIS.setBounds(35, 321, 235, 14);
        CIS.setFont(new Font("Tahoma", Font.BOLD, 14));
        CIS.setForeground(Color.WHITE);
        panel.add(CIS);

        Date date1=new Date();

        date= new JLabel(""+date1);
        date.setBounds(271, 321, 235, 14);
        date.setFont(new Font("Tahoma", Font.BOLD, 14));
        date.setForeground(Color.WHITE);
        panel.add(date);

        JLabel d  = new JLabel("Deposit:");
        d.setBounds(35, 356, 200, 14);
        d.setFont(new Font("Tahoma", Font.BOLD, 14));
        d.setForeground(Color.WHITE);
        panel.add(d);
        dtxt = new JTextField();
        dtxt.setBounds(271, 356, 200, 20);
        dtxt.setBackground(new Color(12,35,64));
        dtxt.setFont(new Font("Tahoma", Font.BOLD, 14));
        dtxt.setForeground(Color.white);
        panel.add(dtxt);

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




        setUndecorated(true);
        setLayout(null);
        setLocation(260,100);
        setSize(850,550);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String name = nametxt.getText();
            String phone = ntxt.getText();
            String idn = idtxt.getText();
            String c = ctxt.getText();
            String id = (String)comboBox.getSelectedItem();
            String gende = (String) gender.getSelectedItem();
            String room = (String)c1.getSelectedItem();
            String Ci= date.getText();
            String d = dtxt.getText();


            try {
                Con con = new Con();
                String str = "insert into customer values('" + idn+ "','" + phone + "','" + name + "','" + gende + "','" + c + "','" + room+ "','" + Ci+ "','" + d+ "')";
                con.statement.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Customer Added");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            new Reception();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new NewCustomer();
    }
}
