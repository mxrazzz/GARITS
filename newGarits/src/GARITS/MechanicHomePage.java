package GARITS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MechanicHomePage extends JDialog {
    private JPanel mechanicHomePanel;
    private JButton viewJobsButton;
    private JButton alterJobStatusButton;
    public User user;

    public MechanicHomePage(JFrame parent){
        super(parent);
        setTitle("Mechanic Screen");
        setContentPane(mechanicHomePanel);
        setMinimumSize(new Dimension(720,480));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        viewJobsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewJobsPage viewJobsPage = new ViewJobsPage(null);

            }
        });

        alterJobStatusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AlterJobStatusPage alterJobStatusPage = new AlterJobStatusPage(null);

            }
        });
        setVisible(true);
    }
}

