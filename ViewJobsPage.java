package GARITS;

import javax.swing.*;
import java.awt.*;

public class ViewJobsPage extends JDialog {

    private JPanel panel1;
    private JPanel viewJobsPanel;

    public ViewJobsPage() {
        JFrame frame = new JFrame();
        frame.add(viewJobsPanel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("View Jobs Screen");
        frame.setSize(720,480);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
