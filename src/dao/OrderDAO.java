package dao;

import db.DBConnection;
import java.sql.*;

public class OrderDAO {

    public void placeOrder(int orderId, int customerId, int productId, int qty) {
        try {
            Connection con = DBConnection.getConnection();

            // Insert into Orders
            PreparedStatement ps1 = con.prepareStatement(
                "INSERT INTO Orders VALUES (?, CURDATE(), 'Pending', 0, ?, 101)"
            );
            ps1.setInt(1, orderId);
            ps1.setInt(2, customerId);
            ps1.executeUpdate();

            // Insert into OrderProduct
            PreparedStatement ps2 = con.prepareStatement(
                "INSERT INTO OrderProduct VALUES (?, ?, ?)"
            );
            ps2.setInt(1, orderId);
            ps2.setInt(2, productId);
            ps2.setInt(3, qty);
            ps2.executeUpdate();

            System.out.println("Order placed successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}