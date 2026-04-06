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

        System.out.println("\n---------------------------------------------------------------");
        System.out.printf("%-10s %-20s %-10s %-10s\n",
                "ID", "Name", "Price", "Stock");
        System.out.println("---------------------------------------------------------------");

        for (Product p : list) {
            System.out.printf("%-10d %-20s %-10.2f %-10d\n",
                    p.getProductID(),
                    p.getName(),
                    p.getPrice(),
                    p.getStock());
        }

        System.out.println("---------------------------------------------------------------");
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

            //check if product exists
            PreparedStatement check = con.prepareStatement(
                    "SELECT COUNT(*) FROM Product WHERE ProductID = ?");
            check.setInt(1, pid);
            ResultSet rs1 = check.executeQuery();

            if (rs1.next() && rs1.getInt(1) == 0) {
                System.out.println("Product ID not found!");
                return -1;
            }

            PreparedStatement ps = con.prepareStatement("SELECT getProductStock(?)");
            ps.setInt(1, pid);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println("Error checking stock!");
        }

        return -1;
    }
}