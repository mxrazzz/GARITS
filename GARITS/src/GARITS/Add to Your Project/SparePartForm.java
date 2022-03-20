package GARITS;

import javax.swing.*;
import java.awt.*;

public class SparePartForm extends JDialog {
    private JPanel sparePartPanel;
    private JComboBox partsSelect;
    private JTextField quantityField;
    private JButton addToMyListButton;
    private JComboBox myList;
    private JButton confirmButton;

    public SparePartForm(JFrame parent){
        super(parent);
        setTitle("Admin Screen");
        setContentPane(sparePartPanel);
        setMinimumSize(new Dimension(720,480));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

    }
}
