import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AdminHome extends JFrame implements ActionListener {

    JButton viewEmployee, addEmployee, updateEmployee, deleteEmployee, upcomingmeeting, signOutButton, filedComplaints, scheduleATask;

    AdminHome(){

        getContentPane().setBackground(new Color(0, 33, 72));
        setLayout(null);

        JLabel heading = new JLabel("Administrative Tools");
        heading.setBounds(450, 22, 400, 40);
        heading.setFont(new Font("Century Gothic", Font.BOLD, 25));
        heading.setForeground(Color.WHITE);
        add(heading);

        addEmployee = new JButton("Add Employee");
        addEmployee.setBounds(450,80,150,40);
        addEmployee.addActionListener(this);
        add(addEmployee);

        viewEmployee = new JButton("View Employees");
        viewEmployee.setBounds(650,80,150,40);
        viewEmployee.addActionListener(this);
        add(viewEmployee);

        updateEmployee = new JButton("Update Employee");
        updateEmployee.setBounds(450,140,150,40);
        updateEmployee.addActionListener(this);
        add(updateEmployee);

        deleteEmployee = new JButton("Delete Employee");
        deleteEmployee.setBounds(650,140,150,40);
        deleteEmployee.addActionListener(this);
        add(deleteEmployee);

        upcomingmeeting = new JButton("View Upcoming Meetings");
        upcomingmeeting.setBounds(450,200,200,40);
        upcomingmeeting.addActionListener(this);
        add(upcomingmeeting);

        filedComplaints = new JButton("View Filed Complaints");
        filedComplaints.setBounds(450,255,200,40);
        filedComplaints.addActionListener(this);
        add(filedComplaints);

        scheduleATask = new JButton("Schedule a Task");
        scheduleATask.setBounds(450,310,200,40);
        scheduleATask.addActionListener(this);
        add(scheduleATask);

        signOutButton = new JButton("Sign Out");
        signOutButton.setBounds(100,500,130,30);
        signOutButton.addActionListener(this);
        add(signOutButton);

        setSize(1120, 630);
        setLocation(300, 100);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addEmployee) {
            setVisible(false);
            new AddEmployee();
        } else if (ae.getSource() == viewEmployee) {
            setVisible(false);
            new ViewEmployee();
        } else if (ae.getSource() == updateEmployee) {
            setVisible(false);
            new ViewEmployee();
        } else if (ae.getSource() == upcomingmeeting) {
            setVisible(false);
            new UpcomingMeetings();
        } else if (ae.getSource() == signOutButton) {
            setVisible(false);
            new Main();
        } else if (ae.getSource() == filedComplaints) {
            setVisible(false);
            new FiledComplaints();
    } else {

        }
    }

    public static void main(String[] args) {
        new AdminHome();
    }
}
