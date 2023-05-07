import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener {

    JButton view, add, update, delete, meeting, signOutButton, fileAComplaintButton, bookAHoliday, videoTraining;

    Home() {

        setLayout(null);

        getContentPane().setBackground(new Color(78, 5, 130));
        setLayout(null);

        JLabel heading = new JLabel("Welcome Back");
        heading.setBounds(450, 22, 400, 40);
        heading.setFont(new Font("Century Gothic", Font.BOLD, 25));
        heading.setForeground(Color.WHITE);
        add(heading);

        JLabel Netlabs = new JLabel("Developed by NETLABS ©");
        Netlabs.setBounds(650, 500, 400, 40);
        Netlabs.setFont(new Font("Century Gothic",Font.PLAIN, 20));
        Netlabs.setForeground(Color.WHITE);
        add(Netlabs);

        add = new JButton("Add Employee");
        add.setBounds(450,80,150,40);
        add.addActionListener(this);
        add(add);

        view = new JButton("View Employees");
        view.setBounds(650,80,150,40);
        view.addActionListener(this);
        add(view);

        update = new JButton("Update Employee");
        update.setBounds(450,140,150,40);
        update.addActionListener(this);
        add(update);

        delete = new JButton("Delete Employee");
        delete.setBounds(650,140,150,40);
        delete.addActionListener(this);
        add(delete);

        meeting = new JButton("Schedule Meeting");
        meeting.setBounds(650,190,150,40);
        meeting.addActionListener(this);
        add(meeting);

        signOutButton = new JButton("Sign Out");
        signOutButton.setBounds(150,500,100,40);
        signOutButton.addActionListener(this);
        add(signOutButton);

        fileAComplaintButton = new JButton("File a Complaint!");
        fileAComplaintButton.setBounds(450,190,150,40);
        fileAComplaintButton.addActionListener(this);
        add(fileAComplaintButton);

        bookAHoliday = new JButton("Book a Holiday");
        bookAHoliday.setBounds(450,250,150,40);
        bookAHoliday.addActionListener(this);
        add(bookAHoliday);

        videoTraining = new JButton("Video Training");
        videoTraining.setBounds(650,250,150,40);
        videoTraining.addActionListener(this);
        add(videoTraining);

        setSize(1100, 630);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            setVisible(false);
            new AddEmployee();
        } else if (ae.getSource() == view) {
            setVisible(false);
            new ViewEmployee();
        } else if (ae.getSource() == update) {
            setVisible(false);
            new ViewEmployee();
        } else if (ae.getSource() == meeting) {
            setVisible(false);
            new ScheduleMeeting();
        } else if (ae.getSource() == signOutButton) {
            setVisible(false);
            new Main();
        } else if (ae.getSource() == fileAComplaintButton) {
            setVisible(false);
            new FileAComplaint();
        } else if (ae.getSource() == delete) {
            setVisible(false);
            new RemoveEmployee();
        } else if (ae.getSource() == bookAHoliday) {
            setVisible(false);
            new HolidayBooking();
        } else if (ae.getSource() == videoTraining) {
            setVisible(false);
            new VideoTraining();
    } else {

        }
    }
    public static void main(String[] args) {
        new Home();
    }
}