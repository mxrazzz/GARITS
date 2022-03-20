package GARITS;

import javax.swing.*;
import java.awt.*;

public class AlterJobStatusPage extends JDialog{

    private JPanel alterJobStatusPanel;

    public AlterJobStatusPage(JFrame parent) {
        super(parent);
        setTitle("Mechanic Screen");
        setContentPane(alterJobStatusPanel);
        setMinimumSize(new Dimension(720, 480));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
