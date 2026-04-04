package dao;

import db.DBConnection;
import model.Product;
import java.sql.*;
import java.util.ArrayList;

//Implementing interface (for polymorphism)
public class ProductDAO implements BaseDAO {

    //Return ArrayList
    public ArrayList<Product> getAllProducts() {

        ArrayList<Product> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM Product");

            while (rs.next()) {

                Product p = new Product();

                // DB → Object (setters)
                p.setProductID(rs.getInt("ProductID"));
                p.setName(rs.getString("Name"));
                p.setCategory(rs.getString("Category"));
                p.setPrice(rs.getDouble("Price"));
                p.setStock(rs.getInt("Stock"));

                list.add(p);
            }

        } 
        catch (SQLException e) {
            System.out.println("Database error while fetching products!");
        } 
        catch (Exception e) {
            System.out.println("Unexpected error!");
        }

        return list;
    }

    //Display products
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

    //REQUIRED for interface (polymorphism)
    @Override
    public void viewAll() {
        viewProducts();
    }

    //Check stock using SQL function
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

        } 
        catch (SQLException e) {
            System.out.println("Database error while checking stock!");
        } 
        catch (Exception e) {
            System.out.println("Unexpected error!");
        }

        return 0;
    }
}