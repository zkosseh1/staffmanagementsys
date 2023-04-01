import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewEmployee extends JFrame implements ActionListener {

    JTable table;
    Choice cempID;
    JButton searchnext, print, update, back;
    ViewEmployee() {

        getContentPane().setBackground(new Color(192,230,255));
        setLayout(null);

        JLabel searchfunction = new JLabel("Search By Emp ID:");
        searchfunction.setBounds(20, 20, 150, 20);
        add(searchfunction);

        cempID = new Choice();
        cempID.setBounds(180, 20, 150, 20);
        add(cempID);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");

            while (rs.next()) {
                cempID.add(rs.getString("empID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        table = new JTable();

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane newscrollpane = new JScrollPane(table);
        newscrollpane.setBounds(0, 100, 900, 400);
        add(newscrollpane);

        searchnext = new JButton("Search: ");
        searchnext.setBounds(20, 70, 100, 20);
        searchnext.addActionListener(this);
        add(searchnext);

        print = new JButton("Print: ");
        print.setBounds(130, 70, 100, 20);
        print.addActionListener(this);
        add(print);

        update = new JButton("Update: ");
        update.setBounds(240, 70, 100, 20);
        update.addActionListener(this);
        add(update);

        back = new JButton("Home: ");
        back.setBounds(350, 70, 100, 20);
        back.addActionListener(this);
        add(back);

        setSize(900,750);
        setLocation(300, 100);
        setVisible(true);
    }


   public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == searchnext) {
            String query = "select * from employee where empID = '"+cempID.getSelectedItem()+"'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == print) {
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == update) {
            setVisible(false);
            new UpdateEmployee(cempID.getSelectedItem());
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new ViewEmployee();
    }
}
