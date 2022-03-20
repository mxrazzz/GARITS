package GARITS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FoundPartPage extends JDialog{
    private JPanel foundPartPanel;
    private JLabel partNum;
    private JLabel partName;
    private JLabel mfr;
    private JLabel vecType;
    private JLabel year;
    private JLabel price;
    private JLabel initialQty;
    private JLabel used;
    private JLabel delivery;
    private JLabel qty;
    private JLabel lowStockThreshold;
    private JLabel description;
    private JButton editThresholdButton;
    private JButton editQtyButton;

    public FoundPartPage(JFrame parent, ArrayList<String> sparePartInfo){
        super(parent);
        setTitle("Found Part");
        partNum.setText("Part Number: " + sparePartInfo.get(0));
        partName.setText("Part Name: " + sparePartInfo.get(1));
        mfr.setText("Manufacturer: " + sparePartInfo.get(2));
        vecType.setText("Vehicle Type: " + sparePartInfo.get(3));
        year.setText("Year(s): " + sparePartInfo.get(4));
        price.setText("Price: £" + sparePartInfo.get(5));
        initialQty.setText("Initial Quantity: " + sparePartInfo.get(6));
        used.setText("Used: " + sparePartInfo.get(7));
        delivery.setText("Delivery: " + sparePartInfo.get(8));
        qty.setText("Quantity: " + sparePartInfo.get(9));
        lowStockThreshold.setText("Low Stock Threshold: " + sparePartInfo.get(10));
        description.setText("Description: " + sparePartInfo.get(11));
        setContentPane(foundPartPanel);
        setMinimumSize(new Dimension(720,480));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        editThresholdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginForm loginForm = new LoginForm(null);
                EditThresholdForm editThresholdForm = new EditThresholdForm(null, sparePartInfo.get(0));
                lowStockThreshold.setText("Low Stock Threshold: " + editThresholdForm.getThreshold());
            }
        });

        editQtyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        setVisible(true);


    }
}
