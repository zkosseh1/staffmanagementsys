import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpcomingMeetings extends JFrame implements ActionListener {

    JTable tableOfUpcomingMeetings;
    JButton viewMeetingDetailsButton, returnToAdminHomeScreen;
    Choice meetingChooserBar;

    UpcomingMeetings(){

        getContentPane().setBackground(new Color(0, 33, 72));
        setLayout(null);

        tableOfUpcomingMeetings = new JTable();

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from meetings");
            tableOfUpcomingMeetings.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane newscrollpane = new JScrollPane(tableOfUpcomingMeetings);
        newscrollpane.setBounds(0, 100, 900, 300);
        add(newscrollpane);

        JLabel chooserBarLabel = new JLabel("Select Meeting");
        chooserBarLabel.setForeground(Color.WHITE);
        chooserBarLabel.setBounds(50,20,150,30);
        chooserBarLabel.setFont(new Font("Century Gothic", Font.PLAIN,14));
        add(chooserBarLabel);

        meetingChooserBar = new Choice();
        meetingChooserBar.setBounds(50, 50, 150, 20);
        add(meetingChooserBar);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from meetings");

            while (rs.next()) {
                meetingChooserBar.add(rs.getString("meetingID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        viewMeetingDetailsButton = new JButton("View Meeting Details");
        viewMeetingDetailsButton.setBounds(230,50,160,20);
        viewMeetingDetailsButton.addActionListener(this);
        add(viewMeetingDetailsButton);

        setSize(900,750);
        setLocation(300, 100);
        setVisible(true);

        returnToAdminHomeScreen = new JButton("Home");
        returnToAdminHomeScreen.setBounds(100,500,150,40);
        returnToAdminHomeScreen.addActionListener(this);
        returnToAdminHomeScreen.setBackground(Color.BLACK);
        returnToAdminHomeScreen.setForeground(Color.WHITE);
        add(returnToAdminHomeScreen);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == viewMeetingDetailsButton) {
            //setVisible(false);
            new ViewMeetingDetails(meetingChooserBar.getSelectedItem());
        } else if (ae.getSource() == returnToAdminHomeScreen) {
            setVisible(false);
            new AdminHome();
        } else {
            setVisible(false);
            new AdminHome();
        }

    }

    public static void main(String[] args) {
        new UpcomingMeetings();
    }
}
