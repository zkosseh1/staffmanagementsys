import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewMeetingDetails extends JFrame implements ActionListener {

    String meetingID;
    JLabel organiserLabel, meetingDate, meetingLocation, meetingTime, OnlineOrInPerson;
    JTextArea generalTopic;
    JButton backToUpcomingMeetingScreen;
    ViewMeetingDetails(String meetingID) {
        getContentPane().setBackground(new Color(0, 33, 72));
        setLayout(null);

        JLabel header = new JLabel("Details");
        header.setFont(new Font("Century Gothic", Font.PLAIN, 25));
        header.setForeground(Color.WHITE);
        header.setBounds(320, 30, 480, 50);
        add(header);

        JLabel organiser = new JLabel("Organiser:");
        organiser.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        organiser.setForeground(Color.WHITE);
        organiser.setBounds(100,100,150,40);
        add(organiser);

        organiserLabel = new JLabel();
        organiserLabel.setForeground(Color.WHITE);
        organiserLabel.setBounds(100,130,150,40);
        add(organiserLabel);

        JLabel meetdate = new JLabel("Meeting date:");
        meetdate.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        meetdate.setForeground(Color.WHITE);
        meetdate.setBounds(100,160,150,40);
        add(meetdate);

        meetingDate = new JLabel();
        meetingDate.setForeground(Color.WHITE);
        meetingDate.setBounds(100,190,150,40);
        add(meetingDate);

        JLabel meetlocation = new JLabel("Meeting Location:");
        meetlocation.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        meetlocation.setForeground(Color.WHITE);
        meetlocation.setBounds(100,220,150,40);
        add(meetlocation);

        meetingLocation = new JLabel();
        meetingLocation.setForeground(Color.WHITE);
        meetingLocation.setBounds(100,250,150,40);
        add(meetingLocation);

        JLabel purpose = new JLabel("Meeting Topic");
        purpose.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        purpose.setForeground(Color.WHITE);
        purpose.setBounds(100,280,150,40);
        add(purpose);

        generalTopic = new JTextArea();
        generalTopic.setBounds(100,320,450,180);
        add(generalTopic);

        JLabel hour = new JLabel("Meeting Time:");
        hour.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        hour.setForeground(Color.WHITE);
        hour.setBounds(100,500,150,40);
        add(hour);

        meetingTime = new JLabel();
        meetingTime.setForeground(Color.WHITE);
        meetingTime.setBounds(100,530,150,40);
        add(meetingTime);

        JLabel teamsoffice = new JLabel("Venue:");
        teamsoffice.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        teamsoffice.setForeground(Color.WHITE);
        teamsoffice.setBounds(100,560,150,40);
        add(teamsoffice);

        OnlineOrInPerson = new JLabel();
        OnlineOrInPerson.setForeground(Color.WHITE);
        OnlineOrInPerson.setBounds(100,590,150,40);
        add(OnlineOrInPerson);

        try {
            Conn c = new Conn();
            String query = "select * from meetings where meetingID = '"+meetingID+"'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                organiserLabel.setText(rs.getString("organiser"));
                meetingDate.setText(rs.getString("mdate"));
                meetingLocation.setText(rs.getString("location"));
                generalTopic.setText(rs.getString("mpurpose"));
                meetingTime.setText(rs.getString("mtime"));
                OnlineOrInPerson.setText(rs.getString("teamsoffice"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        backToUpcomingMeetingScreen = new JButton("Return");
        backToUpcomingMeetingScreen.setBounds(300,600,150,40);
        backToUpcomingMeetingScreen.addActionListener(this);
        backToUpcomingMeetingScreen.setBackground(Color.BLACK);
        backToUpcomingMeetingScreen.setForeground(Color.WHITE);
        add(backToUpcomingMeetingScreen);

        setSize(650,750);
        setLocation(600, 300);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == backToUpcomingMeetingScreen) {
            setVisible(false);
        } else {

        }
    }

    public static void main(String[] args) {
        new ViewMeetingDetails("");
    }
}
