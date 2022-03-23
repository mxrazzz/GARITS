package GARITS;

import javax.swing.*;
import java.awt.*;

public class AlterJobStatusPage extends JDialog{

    private JPanel alterJobStatusPanel;

    public AlterJobStatusPage() {
        JFrame frame = new JFrame();
        frame.add(alterJobStatusPanel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Alter Job Status Screen");
        frame.setSize(720,480);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
