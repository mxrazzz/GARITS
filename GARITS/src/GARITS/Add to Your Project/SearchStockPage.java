package GARITS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;


public class SearchStockPage extends JDialog{
    private JTextField partField;
    private JButton searchButton;
    private JPanel searchStockPanel;
    private ArrayList<String> sparePartInfo = new ArrayList<String>();

    public SearchStockPage(JFrame parent){
        super(parent);
        setTitle("Search Stock Screen");
        setContentPane(searchStockPanel);
        setMinimumSize(new Dimension(720,480));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);



        searchButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String part = partField.getText();
            sparePartInfo = findSparePart(part);
            if (sparePartInfo.size() > 0) {
                FoundPartPage foundPartPage = new FoundPartPage(null, sparePartInfo);
            }
            else {
                //part not found
                JOptionPane.showMessageDialog(SearchStockPage.this,
                        "Part not found",
                        "Try again",
                        JOptionPane.ERROR_MESSAGE);
            }

            }
        });

        setVisible(true);

    }

    private ArrayList findSparePart(String part){

        final String DB_URL = "jdbc:mysql://localhost/garits";
        final String USERNAME = "root";
        final String PASSWORD = "";

        ArrayList<String> sparePartInfo = new ArrayList<String>();

        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully...

            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM spareparts WHERE partName=? OR partNum=?;";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, part);
            preparedStatement.setString(2, part);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                for (int i = 1; i <= 12; i++){
                    sparePartInfo.add(resultSet.getString(i));
                }
            }

            stmt.close();
            conn.close();

        }catch(Exception e){
            e.printStackTrace();
        }

        return sparePartInfo;
    }
}
