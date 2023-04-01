import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateEmployee extends JFrame implements ActionListener {


    JTextField nametextfield, surnametextfield, saltextfield, addrtextfield, teletextfield, eMailtextfield, NItextfield, tfjobtype, tfloc;
 //   JDateChooser dobselector;
//    JComboBox jobtype, locationfield1;
    JLabel empIDlabel;
    JButton add, back;
    String empID;

    UpdateEmployee(String empID) {
        this.empID = empID;
        getContentPane().setBackground(new Color(98, 121, 148));
        setLayout(null);
        JLabel header = new JLabel("Update Employee Details");
        header.setFont(new Font("consolas", Font.BOLD, 25));
        header.setForeground(Color.WHITE);
        header.setBounds(320, 30, 480, 50);
        add(header);

        JLabel namefield = new JLabel("Name");
        namefield.setForeground(Color.WHITE);
        namefield.setBounds(50, 150, 150, 30);
        namefield.setFont(new Font("consolas", Font.PLAIN, 20));
        add(namefield);

        JLabel lblname = new JLabel();
        lblname.setBounds(200, 150, 140, 30);
        add(lblname);

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

        JLabel lbldob = new JLabel();
        lbldob.setBounds(200, 200, 150, 30);
        add(lbldob);

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


        tfjobtype = new JTextField();
        tfjobtype.setBounds(600, 300, 150, 30);
        add(tfjobtype);

        JLabel locationfield = new JLabel("Location");
        locationfield.setBounds(50, 400, 150, 30);
        locationfield.setForeground(Color.WHITE);
        locationfield.setFont(new Font("consolas", Font.PLAIN, 20));
        add(locationfield);


        tfjobtype = new JTextField();
        tfjobtype.setBounds(200, 400, 150, 30);
        add(tfjobtype);

        JLabel NIfield = new JLabel("NI No.");
        NIfield.setBounds(400, 400, 150, 30);
        NIfield.setForeground(Color.WHITE);
        NIfield.setFont(new Font("consolas", Font.PLAIN, 20));
        add(NIfield);

        JLabel lblNiNo = new JLabel();
        lblNiNo.setBounds(600, 400, 140, 30);
        add(lblNiNo);

        JLabel empIDfield = new JLabel("Employee ID");
        empIDfield.setForeground(Color.WHITE);
        empIDfield.setBounds(50, 450, 150, 30);
        empIDfield.setFont(new Font("consolas", Font.PLAIN, 20));
        add(empIDfield);

        empIDlabel = new JLabel();
        empIDlabel.setForeground(Color.WHITE);
        empIDlabel.setBounds(200, 450, 150, 30);
        empIDlabel.setFont(new Font("consolas", Font.PLAIN, 20));
        add(empIDlabel);

        try {
            Conn c = new Conn();
            String query = "select * from employee where empID = '"+empID+"'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                namefield.setText(rs.getString("name"));
                surnametextfield.setText(rs.getString("fname"));
                dobfield.setText(rs.getString("dob"));
                saltextfield.setText(rs.getString("salary"));
                addrtextfield.setText(rs.getString("address"));
                teletextfield.setText(rs.getString("phone"));
                eMailtextfield.setText(rs.getString("email"));
                tfjobtype.setText(rs.getString("jobtitle"));
                locationfield.setText(rs.getString("location"));
                lblNiNo.setText(rs.getString("natinsurno"));
                empIDlabel.setText(rs.getString("empID"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        add = new JButton("Update Details");
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
//            String name = nametextfield.getText();
            String fname = surnametextfield.getText();
//           String dob = ((JTextField) dobselector.getDateEditor().getUiComponent()).getText();
            String salary = saltextfield.getText();
            String address = addrtextfield.getText();
            String phone = teletextfield.getText();
            String email = eMailtextfield.getText();
            String jobtitle = tfjobtype.getText();
//            String location = (String) locationfield1.getSelectedItem();


            try {
                Conn conn = new Conn();
                String query = "update employee set fname = '"+fname+"', salary = '"+salary+"', address = '"+address+"', phone = '"+phone+"', email = '"+email+"', jobtitle = '"+jobtitle+"' where empID = '"+empID+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "The details have been successfully updated on the system!");
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
        new UpdateEmployee("");
    }
}
