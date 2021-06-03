import java.awt.*;
import java.awt.event.*;
import  javax.swing.*;
import javax.swing.border.*;

import java.sql.*;
import java.util.*;
public class UITire {

    private Employee tempDB[] = new Employee[100];
    private int courser;

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private ResultSetMetaData metaData;
    String _url, _username, _password;
    private boolean connectedToDatabase = false;

    private Label headerLab, emplyeeIDLab, nameLab, varLab1, varLab2, RBHeader;
    private JRadioButton teacherRB, securityGaurRB;
    private  JTextField feild1, feild2, feild3, feild4;
    private JButton addBtn, saveBtn, veiwBtn;


    UITire()
    {
        courser = -1;
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame mainFrame = new JFrame("Data Entry");
        //mainFrame.setLayout(new BoxLayout(mainFrame.getContentPane(), BoxLayout.Y_AXIS));


        headerLab = new Label("Employee Details");
        mainFrame.add(headerLab, BoxLayout.Y_AXIS);

        Box RBHolder = Box.createHorizontalBox();
        ButtonGroup buttonGroup = new ButtonGroup();
        RBHeader = new Label("Role:");
        teacherRB = new JRadioButton("Teacher");
        securityGaurRB = new JRadioButton("Security Guard");
        buttonGroup.add(teacherRB);
        buttonGroup.add(securityGaurRB);
        RBHolder.add(RBHeader);
        RBHolder.add(teacherRB);
        RBHolder.add(emplyeeIDLab);

        emplyeeIDLab = new Label("Emplyee ID:");
        nameLab = new Label("Name:");
        varLab1 = new Label("Course Rate:");
        varLab2 = new Label("No. of Publications");
        feild1 = new JTextField();
        feild2 = new JTextField();
        feild3 = new JTextField();
        feild4 = new JTextField();
        Box row1 = Box.createHorizontalBox();
        row1.add(emplyeeIDLab);
        row1.add(feild1);

        Box row2 = Box.createHorizontalBox();
        row2.add(nameLab);
        row2.add(feild2);

        Box row3 = Box.createHorizontalBox();
        row3.add(varLab1);
        row3.add(feild3);

        Box row4 = Box.createHorizontalBox();
        row4.add(varLab2);
        row4.add(feild4);

        Box centerBox = Box.createVerticalBox();
        centerBox.add(row1);
        centerBox.add(row2);
        centerBox.add(row3);
        centerBox.add(row4);

        addBtn = new JButton("Add");
        JPanel addPan = new JPanel();
        addPan.add(addBtn, BorderLayout.EAST);

        Border centerPanelBorder = BorderFactory.createEtchedBorder();
        JPanel centerPanel = new JPanel();
        centerPanel.setBorder(centerPanelBorder);
        centerPanel.add(RBHolder);
        centerPanel.add(centerBox);
        centerPanel.add(addPan);

        saveBtn = new JButton("Save");
        veiwBtn = new JButton("View");
        Box lastRow = Box.createHorizontalBox();
        lastRow.add(saveBtn);
        lastRow.add(veiwBtn);
        JPanel lastPan = new JPanel();
        lastPan.add(lastRow, BorderLayout.NORTH);

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    if(teacherRB.isSelected())
                    {
                        if(Integer.parseInt(varLab1.getText()) < 1500)
                            throw new CourseRateTooLowException();

                        Lecturer object = new Lecturer(Integer.parseInt(emplyeeIDLab.getText()), nameLab.getText(),
                                Float.parseFloat(varLab1.getText()), Integer.parseInt(varLab2.getText()));
                        tempDB[++courser] = object;
                    }
                    else
                    {
                        if(Integer.parseInt(varLab1.getText()) < 800)
                            throw new HourlyRateTooLowException();

                        SecurityGuard object = new SecurityGuard(Integer.parseInt(emplyeeIDLab.getText()), nameLab.getText(),
                                Float.parseFloat(varLab1.getText()), varLab2.getText());
                        tempDB[++courser] = object;
                    }

                }
                catch (CourseRateTooLowException e)
                {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Value Error", JOptionPane.ERROR_MESSAGE);
                }
                catch (HourlyRateTooLowException e)
                {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Value Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        veiwBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Lecturer lecTable[] = new Lecturer[100];
                SecurityGuard secTable[] = new SecurityGuard[100];
                int lecCourser = -1;
                int secCourser = -1;
                for(int i = 0; i <= courser; i++)
                {
                    if(tempDB[i] instanceof Lecturer)
                        lecTable[++lecCourser] =  (Lecturer) tempDB[i];
                    else
                        secTable[++secCourser] = (SecurityGuard) tempDB[i];
                }

                displayLecturersTable(lecTable, lecCourser+1);
                displaySecurityGuardsTable(secTable, secCourser+1);

            }

        });

        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Lecturer lecTable[] = new Lecturer[100];
                SecurityGuard secTable[] = new SecurityGuard[100];
                int lecCourser = -1;
                int secCourser = -1;
                for(int i = 0; i <= courser; i++)
                {
                    if(tempDB[i] instanceof Lecturer)
                        lecTable[++lecCourser] =  (Lecturer) tempDB[i];
                    else
                        secTable[++secCourser] = (SecurityGuard) tempDB[i];
                }

                if ( !connectedToDatabase )
                    throw new IllegalStateException( "Not Connected to Database" );

                try
                {
                    for(int i = 0; i <= lecCourser; i++)
                    {
                        connection.executeUpdate("INSERT INTO Teacher (id, name, courseRate, noOfPublication" +
                                "VALUES ( " + lecTable[i].getId() + ", " + lecTable[i].getName() + ", " + lecTable[i].getCourseRate() + ","
                                + lecTable[i].getNoOfPublication() + ")");
                    }

                    for(int i = 0; i <= secTable; i++)
                    {
                        connection.executeUpdate("INSERT S (id, name, courseRate, noOfPublication" +
                                "VALUES ( " + secTable[i].getId() + ", " + secTable[i].getName() + ", " + secTable[i].getHourlyRate() + ","
                                + secTable[i].getAreaAssigned() + ")");
                    }
                }
                catch (SQLException ex)
                {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
    }

}
