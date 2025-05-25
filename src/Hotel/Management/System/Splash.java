package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame {
    Splash(){
        super("SNAK Hotel Management Systems");

        // Set app icon
        Image icon = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("icon/logo.png"));
        setIconImage(icon);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/splash.gif"));
        JLabel label= new JLabel(imageIcon);
        label.setBounds(0,0,512,512);
        add(label);
        setSize(512,512);
        setVisible(true);
        setLocation(300,50);
        try{
            Thread.sleep(1000);
            new Login();
            setVisible(false);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main (String[] args ){
        new Splash();

    }
}
