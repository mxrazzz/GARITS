package GARITS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Franchisee extends JDialog{
    private JButton customerRecordButton;
    private JButton performanceReportButton;
    private JButton stockReportButton;
    private JButton customerManagementButton;
    private JButton viewJobButton;
    private JButton sparePartsInvoiceButton;
    private JButton jobInvoiceButton;
    private JButton issueJobSheetButton;
    private JButton logoutButton;
    private JButton searchStockButton;
    private JButton editStockAlertButton;
    private JButton orderStockButton;
    private JButton vehicleReportButton1;
    private JPanel franchiseeHomePanel;
    public User user;

    public void ButtonListener() {
        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Customer Management");
                dispose();
                CustomerManagement cs = new CustomerManagement(null);
            }

        };
        customerManagementButton.addActionListener(buttonListener);

    };

    public Franchisee (JFrame parent){
        super (parent);
        ButtonListener();
        setTitle("Franchisee Screen");
        setContentPane(franchiseeHomePanel);
        setMinimumSize(new Dimension(720,480));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);



        }




    }

