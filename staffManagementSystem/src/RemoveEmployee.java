import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class RemoveEmployee extends JFrame implements ActionListener {

    Choice cEMPid;
    JButton deletDis, returnHome;

    RemoveEmployee() {
        getContentPane().setBackground(new Color(78, 5, 130));
        setLayout(null);

        JLabel labelEmpID = new JLabel("Employee ID");
        labelEmpID.setBounds(50,50,100,30);
        labelEmpID.setForeground(Color.WHITE);
        add(labelEmpID);

        cEMPid = new Choice();
        cEMPid.setBounds(200,50,150,30);
        add(cEMPid);

        try {
            Conn c = new Conn();
            String query = "select * from employee";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                cEMPid.add(rs.getString("empID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel labelName = new JLabel("Name:");
        labelName.setBounds(50,100,100,30);
        labelName.setForeground(Color.WHITE);
        add(labelName);

        JLabel lblname = new JLabel();
        lblname.setBounds(200,100,100,30);
        lblname.setForeground(Color.WHITE);
        add(lblname);

        JLabel labelPhone = new JLabel("Phone:");
        labelPhone.setBounds(50,150,100,30);
        labelPhone.setForeground(Color.WHITE);
        add(labelPhone);

        JLabel lblphone = new JLabel();
        lblphone.setBounds(200,150,100,30);
        lblphone.setForeground(Color.WHITE);
        add(lblphone);

        JLabel labelemail = new JLabel("Email:");
        labelemail.setBounds(50,200,100,30);
        labelemail.setForeground(Color.WHITE);
        add(labelemail);

        JLabel lblemail = new JLabel();
        lblemail.setBounds(200,200,250,30);
        lblemail.setForeground(Color.WHITE);
        add(lblemail);

        try {
            Conn c = new Conn();
            String query = "select * from employee where empID = '"+cEMPid.getSelectedItem()+"' ";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                lblname.setText(rs.getString("fname"));
                lblphone.setText(rs.getString("phone"));
                lblemail.setText(rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        cEMPid.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from employee where empID = '"+cEMPid.getSelectedItem()+"' ";
                    ResultSet rs = c.s.executeQuery(query);
                    while (rs.next()) {
                        lblname.setText(rs.getString("fname"));
                        lblphone.setText(rs.getString("phone"));
                        lblemail.setText(rs.getString("email"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        deletDis = new JButton("Delete");
        deletDis.setBounds(80,300,100,30);
        deletDis.setBackground(Color.BLACK);
        deletDis.setBackground(Color.WHITE);
        deletDis.addActionListener(this);
        add(deletDis);

        returnHome = new JButton("Return");
        returnHome.setBounds(220,300,100,30);
        returnHome.setBackground(Color.BLACK);
        returnHome.setBackground(Color.WHITE);
        returnHome.addActionListener(this);
        add(returnHome);

        setSize(1000,400);
        setLocation(300,150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == deletDis) {
            try {
                Conn c = new Conn();
                String query = "delete from employee where empID = '"+cEMPid.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Employee Record Successfully Deleted!");
                setVisible(false);
                new Home();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new RemoveEmployee();
    }
}
