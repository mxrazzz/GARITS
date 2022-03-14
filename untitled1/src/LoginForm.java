import javax.swing.*;
import java.awt.*;

public class LoginForm extends JDialog {

        private JTextField username;
        private JPasswordField passwordField;
        private JButton loginButton;
    private JPanel loginpanel;


        public LoginForm(JFrame parent){
            super(parent);
            setTitle("Login Screen");
            setContentPane(loginpanel);
            setMinimumSize(new Dimension(720,480));
            setModal(true);
            setLocationRelativeTo(parent);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setVisible(true);
        }

    }

