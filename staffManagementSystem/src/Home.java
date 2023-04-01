import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener {

    JButton view, add, update, delete, meeting, signOutButton, fileAComplaintButton;

    Home() {

        setLayout(null);

        ImageIcon badge = new ImageIcon(ClassLoader.getSystemResource("Media/home.jpg"));
        Image badge2 = badge.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon im3 = new ImageIcon(badge2);
        JLabel image = new JLabel(im3);
        image.setBounds(0,0,1120,630);
        add(image);

        JLabel heading = new JLabel("Welcome Back");
        heading.setBounds(450, 22, 400, 40);
        heading.setFont(new Font("Century Gothic", Font.BOLD, 25));
        heading.setForeground(Color.WHITE);
        image.add(heading);

        add = new JButton("Add Employee");
        add.setBounds(450,80,150,40);
        add.addActionListener(this);
        image.add(add);

        view = new JButton("View Employees");
        view.setBounds(650,80,150,40);
        view.addActionListener(this);
        image.add(view);

        update = new JButton("Update Employee");
        update.setBounds(450,140,150,40);
        update.addActionListener(this);
        image.add(update);

        delete = new JButton("Delete Employee");
        delete.setBounds(650,140,150,40);
        delete.addActionListener(this);
        image.add(delete);

        meeting = new JButton("Schedule Meeting");
        meeting.setBounds(650,190,150,40);
        meeting.addActionListener(this);
        image.add(meeting);

        signOutButton = new JButton("Sign Out");
        signOutButton.setBounds(150,500,100,40);
        signOutButton.addActionListener(this);
        add(signOutButton);

        fileAComplaintButton = new JButton("File a Complaint!");
        fileAComplaintButton.setBounds(450,190,150,40);
        fileAComplaintButton.addActionListener(this);
        add(fileAComplaintButton);

        setSize(1120, 630);
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
    } else {

        }
    }
    public static void main(String[] args) {
        new Home();
    }
}