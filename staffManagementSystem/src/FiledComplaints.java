import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class FiledComplaints extends JFrame implements ActionListener {

    JTable complaintsSheet;
    Choice complaintsSelectorScrollBar;
    JButton viewComplaintDetailsButton, ReturnAdminHome;

    FiledComplaints() {

        getContentPane().setBackground(new Color(0, 33, 72));
        setLayout(null);

        complaintsSheet = new JTable();

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from complaints");
            complaintsSheet.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane newscrollpane = new JScrollPane(complaintsSheet);
        newscrollpane.setBounds(0, 100, 900, 300);
        add(newscrollpane);

        complaintsSelectorScrollBar = new Choice();
        complaintsSelectorScrollBar.setBounds(50, 50, 150, 20);
        add(complaintsSelectorScrollBar);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from complaints");

            while (rs.next()) {
                complaintsSelectorScrollBar.add(rs.getString("complaintID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        viewComplaintDetailsButton = new JButton("View Complaint Details");
        viewComplaintDetailsButton.setBounds(230,50,190,20);
        viewComplaintDetailsButton.addActionListener(this);
        add(viewComplaintDetailsButton);


        setSize(900,750);
        setLocation(300, 100);
        setVisible(true);

        ReturnAdminHome = new JButton("Home");
        ReturnAdminHome.setBounds(100,500,150,40);
        ReturnAdminHome.addActionListener(this);
        ReturnAdminHome.setBackground(Color.BLACK);
        ReturnAdminHome.setForeground(Color.WHITE);
        add(ReturnAdminHome);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == viewComplaintDetailsButton) {
            //setVisible(false);
            new ComplaintDetails(complaintsSelectorScrollBar.getSelectedItem());
        } else if (ae.getSource() == ReturnAdminHome) {
            setVisible(false);
            new AdminHome();
        } else {
            setVisible(false);
            new AdminHome();
        }

    }

    public static void main(String[] args) {
        new FiledComplaints();
    }
}


