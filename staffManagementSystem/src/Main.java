import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener {

    JButton startClick, employeeLoginButton;
    Main() {

        JLabel programTitle = new JLabel("Staff Management System Project 2022/23");
        setLayout(null);
        programTitle.setBounds(80, 30, 1200, 60);
        programTitle.setFont(new Font("Ebrima", Font.BOLD, 30));
        programTitle.setForeground(new Color(48,48,48));

        ImageIcon badge = new ImageIcon(ClassLoader.getSystemResource("Media/splashscreen.jpg"));
        Image badge2 = badge.getImage().getScaledInstance(1100,700,Image.SCALE_DEFAULT);
        ImageIcon im3 = new ImageIcon(badge2);
        JLabel image = new JLabel(im3);
        image.setBounds(50,100,1050,500);
        add(image);

        startClick = new JButton("Press to Continue....");
        startClick.setBounds(400,400,300,70);
        startClick.setForeground(Color.WHITE);
        startClick.setBackground(new Color(65, 23, 150));
        startClick.addActionListener(this);
        add(startClick);

        employeeLoginButton = new JButton("Administrator Sign In");
        employeeLoginButton.setBounds(400,500,300,70);
        employeeLoginButton.setForeground(Color.WHITE);
        employeeLoginButton.setBackground(new Color(168, 29, 29));
        employeeLoginButton.addActionListener(this);
        add(employeeLoginButton);

        getContentPane().setBackground(new Color(157, 158, 158));
        add(programTitle);

        setSize(1120, 700); //setting the size of window
        setLocation(100, 300); //location in Windows on opening
        setVisible(true);


    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == startClick) {
            setVisible(false);
            new LoginScreen();
        } else if (ae.getSource() == employeeLoginButton) {
            setVisible(false);
            new AdminLoginScreen();
        }
    }
    public static void main(String[] args) {
        new Main();

    }
}