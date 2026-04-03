package dao;

import db.DBConnection;
import java.sql.*;

public class ProductDAO {

    public void viewProducts() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM Product");

            while (rs.next()) {
                System.out.println(rs.getInt("ProductID") + " - " +
                                   rs.getString("Name") + " - Stock: " +
                                   rs.getInt("Stock"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
