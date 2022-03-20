package GARITS;

import javax.swing.*;
import java.awt.*;

public class ViewJobsPage extends JDialog {

    private JPanel panel1;
    private JPanel viewJobsPanel;

    public ViewJobsPage(JFrame parent) {
        super(parent);
        setTitle("Mechanic Screen");
        setContentPane(viewJobsPanel);
        setMinimumSize(new Dimension(720, 480));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
