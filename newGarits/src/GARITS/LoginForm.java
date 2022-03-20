package GARITS;
//test
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
//too much duplication required - need to create database queries each time

public class LoginForm extends JDialog{
    private JTextField username;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JPanel loginPanel;
    public User user;

    public LoginForm(){
        //setting up the frame
        JFrame frame = new JFrame();
        frame.add(loginPanel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Login Screen");
        frame.setSize(720,480);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = username.getText();
                String password = String.valueOf(passwordField.getPassword());
                String role = "";

                user = getAuthenticatedUser(login, password);

                if (user != null) {
                    user = retrieveRole(user);
                    System.out.println(user.role);
                    if(user.role.equals("Administrator")){
                        //AdminHomePage adminHomePage = new AdminHomePage(null);
                        frame.dispose();
                        AdminHomePage adminHomePage = new AdminHomePage();
                    }
                    else if (user.role.equals("Mechanic")){
                        frame.dispose();
                    }
                    else if (user.role.equals("Franchisee")){
                        frame.dispose();
                        //Franchisee franchiseeHomePage = new Franchisee();

                    }
                    else if (user.role.equals("Foreman")){
                        frame.dispose();
                    }
                    else if (user.role.equals("Receptionist")){
                        frame.dispose();

                    }

                    dispose();
                }
                else {
                    JOptionPane.showMessageDialog(LoginForm.this,
                            "Username or Password Invalid",
                            "Try again",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });


    }


    private User getAuthenticatedUser(String login, String password) {


        final String DB_URL = "jdbc:mysql://localhost/garits";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully...

            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM users WHERE BINARY login=? AND BINARY password=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            //create a class to query MySQL which allows for multiple prepared statements to be
            //sent via array. A for loop should be used to add the
            // relevant variables (column names) to the String sql, I think


            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = new User();
                user.login = resultSet.getString("login");
                user.password = resultSet.getString("password");
            }


            stmt.close();
            conn.close();

        }catch(Exception e){
            e.printStackTrace();
        }


        return user;
    }

    private User retrieveRole(User user){

        final String DB_URL = "jdbc:mysql://localhost/garits";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully...

            Statement stmt = conn.createStatement();
            String sql = "SELECT jobRole FROM users WHERE login=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, user.login);


            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user.role = resultSet.getString("jobRole");
            }
            //user.role = resultSet.getString("jobRole");


            stmt.close();
            conn.close();

        }catch(Exception e){
            e.printStackTrace();
        }


        return user;

    }

}
