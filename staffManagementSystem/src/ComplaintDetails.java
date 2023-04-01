import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ComplaintDetails extends JFrame implements ActionListener {

    String complaintID;
    JLabel complaintDate, complaintCategory, IDNoComplaint, complainee;
    JTextArea complaintdeets, complaintcause;
    JButton backToFiledComplaints;
    ComplaintDetails(String complaintID){
        getContentPane().setBackground(new Color(0, 33, 72));
        setLayout(null);

        JLabel titleS = new JLabel("Complaint Details");
        titleS.setFont(new Font("Century Gothic", Font.PLAIN, 25));
        titleS.setForeground(Color.WHITE);
        titleS.setBounds(180, 30, 480, 50);
        add(titleS);

        JLabel cdate = new JLabel("Complaint Date:");
        cdate.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        cdate.setForeground(Color.WHITE);
        cdate.setBounds(100,100,150,40);
        add(cdate);

        complaintDate = new JLabel();
        complaintDate.setForeground(Color.WHITE);
        complaintDate.setBounds(100,130,150,40);
        add(complaintDate);

        JLabel comcat = new JLabel("Complaint Category:");
        comcat.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        comcat.setForeground(Color.WHITE);
        comcat.setBounds(100,160,250,40);
        add(comcat);

        complaintCategory = new JLabel();
        complaintCategory.setForeground(Color.WHITE);
        complaintCategory.setBounds(100,180,150,40);
        add(complaintCategory);

        JLabel comid = new JLabel("Complaint ID:");
        comid.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        comid.setForeground(Color.WHITE);
        comid.setBounds(100,200,150,40);
        add(comid);

        IDNoComplaint = new JLabel();
        IDNoComplaint.setForeground(Color.WHITE);
        IDNoComplaint.setBounds(100,230,150,40);
        add(IDNoComplaint);

        JLabel complaineelbl = new JLabel("Complainee:");
        complaineelbl.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        complaineelbl.setForeground(Color.WHITE);
        complaineelbl.setBounds(100,260,150,40);
        add(complaineelbl);

        complainee = new JLabel();
        complainee.setForeground(Color.WHITE);
        complainee.setBounds(100,290,150,40);
        add(complainee);

        JLabel comdeets = new JLabel("Complaint Details:");
        comdeets.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        comdeets.setForeground(Color.WHITE);
        comdeets.setBounds(100,320,150,40);
        add(comdeets);

        complaintdeets = new JTextArea();
        complaintdeets.setBounds(100,360,450,120);
        add(complaintdeets);

        JLabel comCause = new JLabel("Cause:");
        comCause.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        comCause.setForeground(Color.WHITE);
        comCause.setBounds(100,490,150,40);
        add(comCause);

        complaintcause = new JTextArea();
        complaintcause.setBounds(100,530,450,100);
        add(complaintcause);

        try {
            Conn c = new Conn();
            String query = "select * from complaints where complaintID = '"+complaintID+"'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                complaintDate.setText(rs.getString("complaintdate"));
                complaintCategory.setText(rs.getString("complaintcategory"));
                IDNoComplaint.setText(rs.getString("complaintID"));
                complainee.setText(rs.getString("complainee"));
                complaintdeets.setText(rs.getString("comdetails"));
                complaintcause.setText(rs.getString("comcause"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setSize(670,750);
        setLocation(600, 300);
        setVisible(true);

        backToFiledComplaints = new JButton("Back");
        backToFiledComplaints.setBounds(200,640,150,40);
        backToFiledComplaints.addActionListener(this);
        backToFiledComplaints.setBackground(Color.BLACK);
        backToFiledComplaints.setForeground(Color.WHITE);
        add(backToFiledComplaints);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == backToFiledComplaints) {
            setVisible(false);
            //new FiledComplaints();
        } else {

        }
    }

    public static void main(String[] args) {
        new ComplaintDetails("");
    }
}
