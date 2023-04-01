import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AdminLoginScreen extends JFrame implements ActionListener {

    JTextField TxUsername, TxPassword;
    AdminLoginScreen(){

        getContentPane().setBackground(new Color(0, 33, 72));
        setLayout(null);

        JLabel sUsername = new JLabel("Username");
        sUsername.setForeground(Color.WHITE);
        sUsername.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        sUsername.setBounds(40,20,100,30);
        add(sUsername);

        TxUsername = new JTextField();
        TxUsername.setBounds(150,20,150,30);
        add(TxUsername);

        JLabel sPassword = new JLabel("Password");
        sPassword.setForeground(Color.WHITE);
        sPassword.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        sPassword.setBounds(40,70,100,30);
        add(sPassword);

        TxPassword = new JTextField();
        TxPassword.setBounds(150,70,150,30);
        add(TxPassword);


        JButton loginButton = new JButton("Press to Continue....");
        loginButton.setBounds(150,140,150,30);
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(new Color(76,106,199));
        loginButton.addActionListener(this);
        add(loginButton);

        setSize(700,300);
        setLocation(300, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String username = TxUsername.getText();
            String password = TxPassword.getText();

            Conn c = new Conn();
            String query = "select * from adminlogin where username = '"+username+"' and password = '"+password+"'";

            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()) {
                setVisible(false);
                new AdminHome();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password");
                setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new AdminLoginScreen();
    }
}
