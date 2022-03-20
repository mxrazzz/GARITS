package GARITS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AdminHomePage extends JFrame {
    private JButton deleteUserBtn;
    private JButton addUserBtn;
    private JButton restoreDbBtn;
    private JButton backupDatabaseButton;
    private JLabel backupDbBtn;
    private JPanel adminHomePanel;
    public User user;

    public AdminHomePage(){
        JFrame frame = new JFrame();
        frame.add(adminHomePanel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Admin Screen");
        frame.setSize(720,480);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);


        addUserBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddUserPage addUserPage = new AddUserPage();

            }
        });
        deleteUserBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteUserPage deleteUserPage = new DeleteUserPage();
            }
        });
    }
}
