package GARITS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AdminHomePage extends JDialog {
    private JButton deleteUserBtn;
    private JButton addUserBtn;
    private JButton restoreDbBtn;
    private JButton backupDatabaseButton;
    private JLabel backupDbBtn;
    private JPanel adminHomePanel;
    public User user;

    public AdminHomePage(JFrame parent){
        super(parent);
        setTitle("Admin Screen");
        setContentPane(adminHomePanel);
        setMinimumSize(new Dimension(720,480));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

    }
}
