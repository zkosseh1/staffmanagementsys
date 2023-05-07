import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class HolidayBooking extends JFrame implements ActionListener {

    JDateChooser firstDayOfHoliday, lastDayofHoliday;
    JTextField eSignatureEmployee, otherRelevantInformation;
    Choice employeeChooser;
    JButton requestHoliday, Cancel;
    HolidayBooking(){

        getContentPane().setBackground(new Color(78, 5, 130));
        setLayout(null);

        ///////////////////
        JLabel header = new JLabel("Request a Holiday");
        header.setFont(new Font("Century Gothic", Font.PLAIN, 25));
        header.setForeground(Color.WHITE);
        header.setBounds(320, 30, 480, 50);
        add(header);

        employeeChooser = new Choice();
        employeeChooser.setBounds(50, 130, 150, 10);;
        add(employeeChooser);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            while (rs.next()) {
                employeeChooser.add(rs.getString("empID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        JLabel employeeID = new JLabel("Employee ID:");
        employeeID.setForeground(Color.WHITE);
        employeeID.setBounds(50, 100, 150, 20);
        employeeID.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        add(employeeID);

        JLabel firstDay = new JLabel("First Day of Holiday");
        firstDay.setForeground(Color.WHITE);
        firstDay.setBounds(50,170,200,20);
        firstDay.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        add(firstDay);

        firstDayOfHoliday = new JDateChooser();
        firstDayOfHoliday.setBounds(50,200,200,20);
        add(firstDayOfHoliday);

        JLabel lastDay = new JLabel("Last Day of Holiday");
        lastDay.setForeground(Color.WHITE);
        lastDay.setBounds(50,230,200,20);
        lastDay.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        add(lastDay);

        lastDayofHoliday = new JDateChooser();
        lastDayofHoliday.setBounds(50,260,200,20);
        add(lastDayofHoliday);

        JLabel eSignature = new JLabel("Employee eSignature");
        eSignature.setForeground(Color.WHITE);
        eSignature.setBounds(50,290,250,20);
        eSignature.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        add(eSignature);

        eSignatureEmployee = new JTextField();
        eSignatureEmployee.setBounds(50,320,200,20);
        add(eSignatureEmployee);

        requestHoliday = new JButton("Request");
        requestHoliday.setBounds(50,600,150,40);
        requestHoliday.setBackground(Color.WHITE);
        requestHoliday.setForeground(Color.BLACK);
        requestHoliday.addActionListener(this);
        add(requestHoliday);

        Cancel = new JButton("Cancel");
        Cancel.setBounds(230,600,150,40);
        Cancel.setBackground(new Color(161, 39, 39));
        Cancel.setForeground(Color.BLACK);
        Cancel.addActionListener(this);
        add(Cancel);


        setSize(900, 750);
        setLocation(300, 100);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == requestHoliday) {
            JOptionPane.showMessageDialog(null, "Your holiday has been requested!");
            setVisible(false);
            new Home();

    } else if (ae.getSource() == Cancel) {
        setVisible(false);
        new Home();
    } else {

    }
    }

    public static void main(String[] args) {
        new HolidayBooking();
    }
}

