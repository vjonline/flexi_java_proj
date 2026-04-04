package dao;

import db.DBConnection;
import java.sql.*;

public class ProductDAO {

    // View all products
    public void viewProducts() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM Product");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("ProductID") + " | " +
                    rs.getString("Name") + " | Stock: " +
                    rs.getInt("Stock")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Check stock using function
    public void checkStock(int pid) {
        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps =
                con.prepareStatement("SELECT getProductStock(?)");

            ps.setInt(1, pid);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Stock = " + rs.getInt(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}