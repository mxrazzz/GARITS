package GARITS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ReceptionistHomePage extends JDialog {
    private JButton createACustomerRecordButton;
    private JButton customerManagementButton;
    private JButton viewJobButton;
    private JButton issueAJobSheetButton;
    private JButton orderStockButton;
    private JButton searchStockButton;
    private JButton invoiceForAJobButton;
    private JButton invoiceForSparePartsButton;
    private JButton stockReportButton;
    private JButton editStockAlertButton;
    private JPanel receptionistHomePanel;

    public ReceptionistHomePage(JFrame parent){
        super(parent);
        setTitle("Receptionist Screen");
        setContentPane(receptionistHomePanel);
        setMinimumSize(new Dimension(720,480));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        searchStockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchStockPage searchStockPage = new SearchStockPage(null);
            }
        });

        setVisible(true);

    }
}
