package GARITS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class DeleteUserPage extends JFrame {
    private JPanel deleteUserPanel;
    private JTextField usernameField;
    private JButton deleteUserBtn;
    public User user;

    public DeleteUserPage(){
        JFrame frame = new JFrame();
        frame.add(deleteUserPanel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Delete User Screen");
        frame.setSize(720,480);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        deleteUserBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = usernameField.getText();

                user = getUser(login);

                if (user != null){
                    deleteUser();
                    frame.dispose();

                }
                else {
                    JOptionPane.showMessageDialog(DeleteUserPage.this,
                            "Username Invalid",
                            "Try again",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private User getUser(String login) {


        final String DB_URL = "jdbc:mysql://localhost/garits";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully...

            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM users WHERE BINARY login=? ";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, login);

            //create a class to query MySQL which allows for multiple prepared statements to be
            //sent via array. A for loop should be used to add the
            // relevant variables (column names) to the String sql, I think


            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = new User();
                user.login = resultSet.getString("login");

            }


            stmt.close();
            conn.close();

        }catch(Exception e){
            e.printStackTrace();
        }


        return user;
    }

    private void deleteUser(){
        final String DB_URL = "jdbc:mysql://localhost/garits";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully...

            Statement stmt = conn.createStatement();

            String sql = "DELETE FROM users where login=?";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, user.login);


            preparedStatement.executeUpdate();
            preparedStatement.close();


        }catch(Exception b){
            b.printStackTrace();
        }


    }
    }


