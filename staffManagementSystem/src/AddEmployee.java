import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddEmployee extends JFrame implements ActionListener {

    Random ranNoGenerator = new Random();
    int number = ranNoGenerator.nextInt(99999);

    JTextField nametextfield, surnametextfield, saltextfield, addrtextfield, teletextfield, eMailtextfield, NItextfield;
    JDateChooser dobselector;
    JComboBox jobtype, locationfield1;
    JLabel empIDlabel;
    JButton add, back;

    AddEmployee() {
        getContentPane().setBackground(new Color(98, 121, 148));
        setLayout(null);
        JLabel header = new JLabel("Add New Employee Details");
        header.setFont(new Font("consolas", Font.BOLD, 25));
        header.setForeground(Color.WHITE);
        header.setBounds(320, 30, 480, 50);
        add(header);

        JLabel namefield = new JLabel("Name");
        namefield.setForeground(Color.WHITE);
        namefield.setBounds(50, 150, 150, 30);
        namefield.setFont(new Font("consolas", Font.PLAIN, 20));
        add(namefield);

        nametextfield = new JTextField();
        nametextfield.setBounds(200, 150, 140, 30);
        add(nametextfield);

        JLabel surnamefield = new JLabel("Surname");
        surnamefield.setForeground(Color.WHITE);
        surnamefield.setBounds(400, 150, 150, 30);
        surnamefield.setFont(new Font("consolas", Font.PLAIN, 20));
        add(surnamefield);

        surnametextfield = new JTextField();
        surnametextfield.setBounds(600, 150, 140, 30);
        add(surnametextfield);

        JLabel dobfield = new JLabel("Date of Birth");
        dobfield.setForeground(Color.WHITE);
        dobfield.setBounds(50, 200, 150, 30);
        dobfield.setFont(new Font("consolas", Font.PLAIN, 20));
        add(dobfield);

        dobselector = new JDateChooser();
        dobselector.setBounds(200, 200, 150, 30);
        add(dobselector);

        JLabel salaryfield = new JLabel("Salary");
        salaryfield.setForeground(Color.WHITE);
        salaryfield.setBounds(400, 200, 150, 30);
        salaryfield.setFont(new Font("consolas", Font.PLAIN, 20));
        add(salaryfield);

        saltextfield = new JTextField();
        saltextfield.setBounds(600, 200, 140, 30);
        add(saltextfield);

        JLabel addressfield = new JLabel("Address");
        addressfield.setForeground(Color.WHITE);
        addressfield.setBounds(50, 250, 150, 30);
        addressfield.setFont(new Font("consolas", Font.PLAIN, 20));
        add(addressfield);

        addrtextfield = new JTextField();
        addrtextfield.setBounds(200, 250, 140, 30);
        add(addrtextfield);

        JLabel telefield = new JLabel("Phone No.");
        telefield.setForeground(Color.WHITE);
        telefield.setBounds(400, 250, 150, 30);
        telefield.setFont(new Font("consolas", Font.PLAIN, 20));
        add(telefield);

        teletextfield = new JTextField();
        teletextfield.setBounds(600, 250, 140, 30);
        add(teletextfield);

        JLabel eMailfield = new JLabel("E-Mail");
        eMailfield.setForeground(Color.WHITE);
        eMailfield.setBounds(50, 300, 150, 30);
        eMailfield.setFont(new Font("consolas", Font.PLAIN, 20));
        add(eMailfield);

        eMailtextfield = new JTextField();
        eMailtextfield.setBounds(200, 300, 140, 30);
        add(eMailtextfield);

        JLabel jobtitlefield = new JLabel("Job Title");
        jobtitlefield.setForeground(Color.WHITE);
        jobtitlefield.setBounds(400, 300, 150, 30);
        jobtitlefield.setFont(new Font("consolas", Font.PLAIN, 20));
        add(jobtitlefield);

        String jobtitles[] = {"Production Operative", "Accounting", "Quality Control", "Sales Dept.", "Purchasing", "Industrial Engineer", "Logistics", "HR", "Training/Safety",
        "Security", "Networking", "Maintenance",};
        jobtype = new JComboBox(jobtitles);
        jobtype.setBackground(new Color(207, 207, 207));
        jobtype.setBounds(600, 300, 150, 30);
        add(jobtype);

        JLabel locationfield = new JLabel("Location");
        locationfield.setBounds(50, 400, 150, 30);
        locationfield.setForeground(Color.WHITE);
        locationfield.setFont(new Font("consolas", Font.PLAIN, 20));
        add(locationfield);

        String locations[] = {"Birmingham", "Stourbridge"};
        locationfield1 = new JComboBox(locations);
        locationfield1.setBackground(new Color(207, 207, 207));
        locationfield1.setBounds(200, 400, 150, 30);
        add(locationfield1);

        JLabel NIfield = new JLabel("NI No.");
        NIfield.setBounds(400, 400, 150, 30);
        NIfield.setForeground(Color.WHITE);
        NIfield.setFont(new Font("consolas", Font.PLAIN, 20));
        add(NIfield);

        NItextfield = new JTextField();
        NItextfield.setBounds(600, 400, 140, 30);
        add(NItextfield);

        JLabel empIDfield = new JLabel("Employee ID");
        empIDfield.setForeground(Color.WHITE);
        empIDfield.setBounds(50, 450, 150, 30);
        empIDfield.setFont(new Font("consolas", Font.PLAIN, 20));
        add(empIDfield);

        empIDlabel = new JLabel("" + number);
        empIDlabel.setForeground(Color.WHITE);
        empIDlabel.setBounds(200, 450, 150, 30);
        empIDlabel.setFont(new Font("consolas", Font.PLAIN, 20));
        add(empIDlabel);

        add = new JButton("Add Details");
        add.setBounds(250,600,150,40);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBounds(450,600,150,40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);

        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String name = nametextfield.getText();
            String fname = surnametextfield.getText();
            String dob = ((JTextField) dobselector.getDateEditor().getUiComponent()).getText();
            String salary = saltextfield.getText();
            String address = addrtextfield.getText();
            String phone = teletextfield.getText();
            String email = eMailtextfield.getText();
            String jobtitle = (String) jobtype.getSelectedItem();
            String location = (String) locationfield1.getSelectedItem();
            String natinsurno = NItextfield.getText();
            String empID = empIDlabel.getText();

            try {
                Conn conn = new Conn();
                String query = "insert into employee values('"+name+"', '"+fname+"', '"+dob+"', '"+salary+"', '"+address+"', '"+phone+"', '"+email+"', '"+jobtitle+"', '"+location+"', '"+natinsurno+"', '"+empID+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "The details have been successfully added to system!");
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
        new AddEmployee();
    }
}
