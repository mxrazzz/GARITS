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

    public LoginForm(JFrame parent){
        super(parent);
        setTitle("Login Screen");
        setContentPane(loginPanel);
        setMinimumSize(new Dimension(720,480));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

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

    setVisible(true);
}


    private User getAuthenticatedUser(String login, String password) {
        //User user = null;

        final String DB_URL = "jdbc:mysql://localhost/garits";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully...

            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM users WHERE login=? AND password=?";
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
