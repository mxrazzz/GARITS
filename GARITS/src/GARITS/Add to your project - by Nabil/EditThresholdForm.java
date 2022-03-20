package GARITS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

public class EditThresholdForm extends JDialog {
    private JPanel editThresholdPanel;
    private JTextField thresholdField;
    private JButton confirmButton;
    private String threshold;



    public EditThresholdForm(JFrame parent, String partNum) {
        super(parent);
        setTitle("Edit threshold Screen");
        setContentPane(editThresholdPanel);
        setMinimumSize(new Dimension(720,480));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                threshold = thresholdField.getText();
                updateThreshold(threshold, partNum);
                //then dispose this UI window
            }
        });

        setVisible(true);
    }

    private void updateThreshold(String threshold, String partNum){

        final String DB_URL = "jdbc:mysql://localhost/garits";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully...

            Statement stmt = conn.createStatement();
            String sql = "UPDATE spareparts SET LowStockThreshold = ? WHERE PartNum = ?;";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, threshold);
            preparedStatement.setString(2, partNum);

            ResultSet resultSet = preparedStatement.executeQuery();

            stmt.close();
            conn.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public String getThreshold() {
        return threshold;
    }

    public void setThreshold(String threshold) {
        this.threshold = threshold;
    }
}
