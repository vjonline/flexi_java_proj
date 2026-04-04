package dao;

import db.DBConnection;
import java.sql.*;

public class OrderDAO {

    // Place order
    public void placeOrder(int oid, int cid, int pid, int qty) {

        try {
            Connection con = DBConnection.getConnection();

            // Get product price
            PreparedStatement ps1 =
                con.prepareStatement("SELECT Price FROM Product WHERE ProductID=?");

            ps1.setInt(1, pid);
            ResultSet rs = ps1.executeQuery();

            double price = 0;
            if (rs.next()) price = rs.getDouble(1);

            double total = price * qty;

            // Insert into Orders
            PreparedStatement ps2 = con.prepareStatement(
                "INSERT INTO Orders VALUES (?, CURDATE(), 'Pending', ?, ?, 101)"
            );

            ps2.setInt(1, oid);
            ps2.setDouble(2, total);
            ps2.setInt(3, cid);
            ps2.executeUpdate();

            // Insert into OrderProduct
            PreparedStatement ps3 = con.prepareStatement(
                "INSERT INTO OrderProduct VALUES (?, ?, ?)"
            );

            ps3.setInt(1, oid);
            ps3.setInt(2, pid);
            ps3.setInt(3, qty);
            ps3.executeUpdate();

            System.out.println("Order placed successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View all orders
    public void viewOrders() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM Orders");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("OrderID") + " | " +
                    rs.getDouble("TotalAmount")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}