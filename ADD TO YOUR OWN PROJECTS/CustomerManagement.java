package GARITS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerManagement extends JDialog {
    private JButton customerNameButton;
    private JButton postcodeButton;
    private JButton accountTypeButton1;
    private JButton dateButton;
    private JButton addressButton1;
    private JButton emailButton;
    private JButton fixedDiscountButton;
    private JButton flexibleDiscountButton;
    private JButton variableDiscountButton;
    private JPanel customerManagementPanel;
    private JButton addVehicleButton;
    private JButton recordPaymentButton;
    private JButton payLateButton;
    private JButton confirmButton;
    private JButton goBackButton;
    public User user;

    public void ButtonListener() {
        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Back to Franchisee home page");
                dispose();
                Franchisee franchiseeHome = new Franchisee(null);
            }

        };
        goBackButton.addActionListener(buttonListener);

    };

    public CustomerManagement (JFrame parent){
        super (parent);
        ButtonListener();
        setTitle("Franchisee Screen");
        setContentPane(customerManagementPanel);
        setMinimumSize(new Dimension(720,480));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

    }


}
