import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;

public class ScheduleMeeting extends JFrame implements ActionListener {

    /////////////random meeting ID number generator//////////////////
    Random rand = new Random();
    int min = 1000;
    int max = 9999;
    int randomMeetingIDgenerator = rand.nextInt((max - min) + 1) + min;
    ///////////// end of random meeting ID number generator////////////

    Choice employeeChooser;
    JDateChooser meetingDateChooser;
    JTextField organisersNameTextField;
    JTextArea topicAndSubjectTextField;
    JComboBox meetingLocationSelector, timeSelector, OfficeOrLive;
    JButton scheduleMeeting, Return2Home;
    JLabel meetingIDfield;
    ScheduleMeeting(){

        getContentPane().setBackground(new Color(0, 33, 72));
        setLayout(null);
        JLabel header = new JLabel("Schedule a Meeting");
        header.setFont(new Font("Century Gothic", Font.PLAIN, 25));
        header.setForeground(Color.WHITE);
        header.setBounds(320, 30, 480, 50);
        add(header);

        ////////////meeting ID generator section////////////
        JLabel meetingIDlabel = new JLabel("Meeting ID");
        meetingIDlabel.setForeground(Color.WHITE);
        meetingIDlabel.setBounds(400, 70, 150, 30);
        meetingIDlabel.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        add(meetingIDlabel);

        meetingIDfield = new JLabel("" + randomMeetingIDgenerator);
        meetingIDfield.setForeground(Color.WHITE);
        meetingIDfield.setBounds(400, 90, 150, 30);
        meetingIDfield.setFont(new Font("Century Gothic", Font.BOLD, 14));
        add(meetingIDfield);
        ///////////////end of meeting ID generator///////////

        ///////////employeechooser section///////
        employeeChooser = new Choice();
        employeeChooser.setBounds(50, 100, 150, 20);;
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
        employeeID.setBounds(50, 70, 150, 30);
        employeeID.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        add(employeeID);
        /////////////end of employeechooser section//////////

        ////////////organiser's name section//////////
        JLabel organiserName = new JLabel("Organiser's Name:");
        organiserName.setForeground(Color.WHITE);
        organiserName.setBounds(50, 130,150,20);
        organiserName.setFont(new Font("Century Gothic", Font.PLAIN,14));
        add(organiserName);

        organisersNameTextField = new JTextField();
        organisersNameTextField.setBounds(50, 150,150,20);
        add(organisersNameTextField);
        /////////////////end of organiser's name section//////////

        ////////////////meeting date section///////////////
        meetingDateChooser = new JDateChooser();
        meetingDateChooser.setBounds(50,200,150,20);
        add(meetingDateChooser);

        JLabel meetingDateLabel = new JLabel("Select a Date");
        meetingDateLabel.setForeground(Color.WHITE);
        meetingDateLabel.setBounds(50,180,150,20);
        meetingDateLabel.setFont(new Font("Century Gothic", Font.PLAIN,14));
        add(meetingDateLabel);
        //////////////////////end of meeting date section///////////////

        //////////////////////meeting location selection////////////////
        JLabel meetingLocationLabel = new JLabel("Select Meeting Location:");
        meetingLocationLabel.setForeground(Color.WHITE);
        meetingLocationLabel.setBounds(50,230,200,20);
        meetingLocationLabel.setFont(new Font("Century Gothic", Font.PLAIN,14));
        add(meetingLocationLabel);

        String possibleLocations[] = {"Birmingham", "Stourbridge", "Coventry", "LIVE"};
        meetingLocationSelector = new JComboBox(possibleLocations);
        meetingLocationSelector.setBackground(new Color(194, 209, 237));
        meetingLocationSelector.setBounds(50,250,150,20);
        add(meetingLocationSelector);
        ///////////////////end of meeting location section////////////////

        ///////////////////meeting description and topic section////////////
        JLabel generalTopicAndSubjectOfMeeting = new JLabel("Description of Meeting and Subject:");
        generalTopicAndSubjectOfMeeting.setForeground(Color.WHITE);
        generalTopicAndSubjectOfMeeting.setBounds(50,280,300,20);
        generalTopicAndSubjectOfMeeting.setFont(new Font("Century Gothic", Font.PLAIN,14));
        add(generalTopicAndSubjectOfMeeting);

        topicAndSubjectTextField = new JTextArea();
        topicAndSubjectTextField.setBounds(50,300,500,150);
        add(topicAndSubjectTextField);
        //////////////////end of meeting description and topic section/////////////

        //////////////////meeting time section////////////////////////////
        JLabel timeOfMeeting = new JLabel("Choose a Time:");
        timeOfMeeting.setForeground(Color.WHITE);
        timeOfMeeting.setBounds(50,460,180,20);
        timeOfMeeting.setFont(new Font("Century Gothic", Font.PLAIN,14));
        add(timeOfMeeting);

        String availableTimesAndHours[] = {"9:00 AM", "9:30 AM", "10:00 AM", "10:30 AM", "11:00 AM", "11:30 AM", "12:00 PM", "12:30 PM",
        "1:00 PM", "1:30 PM", "2:00 PM", "2:30 PM", "3:00 PM", "3:30 PM", "4:00 PM", "4:30 PM", "5:00 PM"};
        timeSelector = new JComboBox(availableTimesAndHours);
        timeSelector.setBackground(new Color(194, 209, 237));
        timeSelector.setBounds(50,480,150,20);
        add(timeSelector);
        /////////////////////end of meeting time section//////////////////////

        /////////////////////in person or live choice////////////////////////
        JLabel inPersonOrOnlineMeet = new JLabel("In Person or Online?");
        inPersonOrOnlineMeet.setForeground(Color.WHITE);
        inPersonOrOnlineMeet.setBounds(50,510,150,20);
        inPersonOrOnlineMeet.setFont(new Font("Century Gothic", Font.PLAIN,14));
        add(inPersonOrOnlineMeet);

        String OptionsForVenue[] = {"In Office", "Online"};
        OfficeOrLive = new JComboBox(OptionsForVenue);
        OfficeOrLive.setBackground(new Color(194, 209, 237));
        OfficeOrLive.setBounds(50,530,150,20);
        add(OfficeOrLive);
        ///////////////////end of person or live choice section///////////////

        ////////////////// buttons section //////////////////////////
        scheduleMeeting = new JButton("Schedule Meeting");
        scheduleMeeting.setBounds(50,580,150,40);
        scheduleMeeting.setBackground(new Color(135, 187, 250));
        scheduleMeeting.setForeground(Color.BLACK);
        scheduleMeeting.addActionListener(this);
        add(scheduleMeeting);

        Return2Home = new JButton("Back");
        Return2Home.setBounds(220,580,150,40);
        Return2Home.setBackground(new Color(135, 187, 250));
        Return2Home.setForeground(Color.BLACK);
        Return2Home.addActionListener(this);
        add(Return2Home);

        setSize(900, 750);
        setLocation(300, 50);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == scheduleMeeting) {
        //    String employID = (String) employeeChooser.getSelectedItem();
            String generatedIDmeeting = meetingIDfield.getText();
            String organisername = organisersNameTextField.getText();
            String meetindate = ((JTextField) meetingDateChooser.getDateEditor().getUiComponent()).getText();
            String meetlocation = (String) meetingLocationSelector.getSelectedItem();
            String generaltopic = topicAndSubjectTextField.getText();
            String timeofmeet = (String) timeSelector.getSelectedItem();
            String meetvenue = (String) OfficeOrLive.getSelectedItem();
            try {
                Conn conn = new Conn();
                String query = "insert into meetings values('"+generatedIDmeeting+"','"+organisername+"', '"+meetindate+"', '"+meetlocation+"', '"+generaltopic+"', '"+timeofmeet+"', '"+meetvenue+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "The meeting has been scheduled!");
                setVisible(false);
                new Home();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == Return2Home) {
            setVisible(false);
            new Home();
        } else {

        }
    }

    public static void main(String[] args) {
        new ScheduleMeeting();
    }
}
