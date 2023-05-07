import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class FileAComplaint extends JFrame implements ActionListener {

    //////////////date/////////////////
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
    // Get the current date
    Date currentDate = new Date();
    // Format the date as a string
    String dateString = dateFormat.format(currentDate);
    // Print the date string

    /////////////random meeting ID number generator//////////////////
    Random rand = new Random();
    int min = 1000;
    int max = 9999;
    int randomMeetingIDgenerator = rand.nextInt((max - min) + 1) + min;
    ///////////// end of random meeting ID number generator////////////
    Choice employeeSelector;
    JButton submitComplaintButton, HomeBtn;
    JLabel complaintIDNumber, complaintDate;
    JTextField organisersNameTextField;
    JTextArea detailsFromComplaint, causeOfComplaint;
    JComboBox CategoryOfComplaint;
    FileAComplaint(){
        getContentPane().setBackground(new Color(78, 5, 130));
        setLayout(null);
        ////////////////////////////headers/////////////////////////
        JLabel header = new JLabel("File a Complaint");
        header.setFont(new Font("Century Gothic", Font.PLAIN, 25));
        header.setForeground(Color.WHITE);
        header.setBounds(320, 30, 480, 50);
        add(header);

        JLabel subheader = new JLabel("Your Feedback Matters");
        subheader.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        subheader.setForeground(Color.WHITE);
        subheader.setBounds(320, 55, 480, 50);
        add(subheader);
        ////////////////////////////end of headers section/////////////

        /////////////////////////employee chooser////////////////
        employeeSelector = new Choice();
        employeeSelector.setBounds(50, 100, 150, 20);;
        add(employeeSelector);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            while (rs.next()) {
                employeeSelector.add(rs.getString("empID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        JLabel employeeID = new JLabel("Employee ID:");
        employeeID.setForeground(Color.WHITE);
        employeeID.setBounds(50, 70, 150, 30);
        employeeID.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        add(employeeID);
        /////////////end of employeechooser section//////////

        ////////////complaintee name section//////////
        JLabel organiserName = new JLabel("Complaint Category" );
        organiserName.setForeground(Color.WHITE);
        organiserName.setBounds(50, 130,200,20);
        organiserName.setFont(new Font("Century Gothic", Font.PLAIN,14));
        add(organiserName);

        String categoriesOfComplaints[] = {"Working Conditions", "Payments/Benefits", "Overwork", "Bullying/Harassment", "Discrimination/Racism"};
        CategoryOfComplaint = new JComboBox<>(categoriesOfComplaints);
        CategoryOfComplaint.setBounds(50, 150,150,20);
        add(CategoryOfComplaint);
        /////////////////end of complaintee name section//////////

        ////////////meeting ID generator section////////////
        JLabel meetingIDlabel = new JLabel("Complaint ID Number");
        meetingIDlabel.setForeground(Color.WHITE);
        meetingIDlabel.setBounds(50, 170, 200, 30);
        meetingIDlabel.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        add(meetingIDlabel);

        complaintIDNumber = new JLabel("" + randomMeetingIDgenerator);
        complaintIDNumber.setForeground(Color.WHITE);
        complaintIDNumber.setBounds(50, 190, 150, 30);
        complaintIDNumber.setFont(new Font("Century Gothic", Font.BOLD, 14));
        add(complaintIDNumber);
        ///////////////end of meeting ID generator///////////

        ////////////////meeting date section///////////////
        JLabel meetingDateLabel = new JLabel("Dated:");
        meetingDateLabel.setForeground(Color.WHITE);
        meetingDateLabel.setBounds(50,220,150,20);
        meetingDateLabel.setFont(new Font("Century Gothic", Font.PLAIN,14));
        add(meetingDateLabel);

        complaintDate = new JLabel("" + dateString);
        complaintDate.setBounds(50,240,150,20);
        complaintDate.setForeground(Color.WHITE);
        complaintDate.setFont(new Font("Century Gothic", Font.BOLD,14));
        add(complaintDate);
        //////////////////////end of meeting date section///////////////

        /////////////////////details textbox/////////////////////
        JLabel detailscomplaint = new JLabel("Complaint Details:");
        detailscomplaint.setForeground(Color.WHITE);
        detailscomplaint.setBounds(50,270,150,20);
        detailscomplaint.setFont(new Font("Century Gothic", Font.PLAIN,14));
        add(detailscomplaint);

        detailsFromComplaint = new JTextArea();
        detailsFromComplaint.setBounds(50,290,500,150);
        add(detailsFromComplaint);
        //////////////////////end of details textbox//////////////////////

        //////////////////////////////////////////////////////////
        JLabel causeLabel = new JLabel("Cause of Problem:");
        causeLabel.setForeground(Color.WHITE);
        causeLabel.setBounds(50,450,150,30);
        causeLabel.setFont(new Font("Century Gothic", Font.PLAIN,14));
        add(causeLabel);

        causeOfComplaint = new JTextArea();
        causeOfComplaint.setBounds(50,490,500,100);
        add(causeOfComplaint);
        ///////////////////////////////////////////////////////////////

        submitComplaintButton = new JButton("Submit Complaint");
        submitComplaintButton.setBounds(50,620,150,40);
        submitComplaintButton.setBackground(new Color(135, 187, 250));
        submitComplaintButton.setForeground(Color.WHITE);
        submitComplaintButton.addActionListener(this);
        add(submitComplaintButton);

        HomeBtn = new JButton("Return");
        HomeBtn.setBounds(300,620,150,40);
        HomeBtn.setBackground(new Color(74, 74, 74));
        HomeBtn.setForeground(Color.BLACK);
        HomeBtn.addActionListener(this);
        add(HomeBtn);

        setSize(900, 750);
        setLocation(300, 50);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == submitComplaintButton) {
                String theDate = complaintDate.getText();
                String theCategory = (String) CategoryOfComplaint.getSelectedItem();
                String ComplaintIDNo = complaintIDNumber.getText();
                String complainee = (String) employeeSelector.getSelectedItem();
                String complaintdeets = detailsFromComplaint.getText();
                String complaintcause = causeOfComplaint.getText();

                try {
                    Conn conn = new Conn();
                    String query = "insert into complaints values('"+theDate+"','"+theCategory+"', '"+ComplaintIDNo+"', '"+complainee+"', '"+complaintdeets+"', '"+complaintcause+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "The Complaint Has Been Filed!");

                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else if(ae.getSource() == HomeBtn ) {
                setVisible(false);
                new Home();
            } else {

            }
    }

    public static void main(String[] args) {
        new FileAComplaint();
    }
}


