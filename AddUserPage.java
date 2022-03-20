package GARITS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AddUserPage extends JFrame{
    private JPanel addUserPanel;
    private JTextField nameField;
    private JComboBox jobRoleField;
    private JTextField loginField;
    private JPasswordField passwordField;
    private JButton addUserBtn;

    public User user;

    public AddUserPage(){
        JFrame frame = new JFrame();
        frame.add(addUserPanel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Add User Screen");
        frame.setSize(720,480);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);


        addUserBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addUser();
                frame.dispose();


            }
        });
    }

    private void addUser(){
        String nameDB = nameField.getText();
        String jobRoleDB = (String) jobRoleField.getSelectedItem();
        String loginDB = loginField.getText();
        String passwordDB = String.valueOf(passwordField.getPassword());

        final String DB_URL = "jdbc:mysql://localhost/garits";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully...

            Statement stmt = conn.createStatement();

            String sql = "INSERT INTO users " + "VALUES (?,?,?,?)";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, nameDB);
            preparedStatement.setString(2, jobRoleDB);
            preparedStatement.setString(3, loginDB);
            preparedStatement.setString(4, passwordDB);

            preparedStatement.executeUpdate();
            preparedStatement.close();



        }catch(Exception b){
            b.printStackTrace();
        }


    }





}
