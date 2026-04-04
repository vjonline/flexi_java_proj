package dao;

import db.DBConnection;
import model.Product;
import java.sql.*;
import java.util.ArrayList;

public class ProductDAO {

    // ✅ Return ArrayList instead of List
    public ArrayList<Product> getAllProducts() {

        ArrayList<Product> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM Product");

            while (rs.next()) {

                Product p = new Product();

                // setters (DB → object)
                p.setProductID(rs.getInt("ProductID"));
                p.setName(rs.getString("Name"));
                p.setCategory(rs.getString("Category"));
                p.setPrice(rs.getDouble("Price"));
                p.setStock(rs.getInt("Stock"));

                list.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // ✅ Display products
    public void viewProducts() {

        ArrayList<Product> list = getAllProducts();

        for (Product p : list) {
            System.out.println(
                p.getProductID() + " | " +
                p.getName() + " | Price: " +
                p.getPrice() + " | Stock: " +
                p.getStock()
            );
        }
    }

    // ✅ Check stock
    public int checkStock(int pid) {

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps =
                con.prepareStatement("SELECT getProductStock(?)");

            ps.setInt(1, pid);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
}