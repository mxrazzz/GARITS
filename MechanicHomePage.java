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

    public MechanicHomePage(){
       /* super(parent);
        setTitle("Mechanic Screen");
        setContentPane(mechanicHomePanel);
        setMinimumSize(new Dimension(720,480));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); */
        JFrame frame = new JFrame();
        frame.add(mechanicHomePanel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Mechanic Home Screen");
        frame.setSize(720,480);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);


        viewJobsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new ViewJobsPage();

            }
        });

        alterJobStatusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new AlterJobStatusPage();

            }
        });
    }
}

